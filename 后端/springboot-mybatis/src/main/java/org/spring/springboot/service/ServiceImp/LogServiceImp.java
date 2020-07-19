package org.spring.springboot.service.ServiceImp;

import org.spring.springboot.dao.devices.DevBuyDao;
import org.spring.springboot.dao.devices.DevIdDao;
import org.spring.springboot.dao.devices.DevWorkStatusDao;
import org.spring.springboot.dao.logs.*;
import org.spring.springboot.dao.users.UserAccountDao;
import org.spring.springboot.dao.users.UserAuthDao;
import org.spring.springboot.domain.Device;
import org.spring.springboot.domain.Log;
import org.spring.springboot.domain.User;
import org.spring.springboot.service.LogService;
import org.spring.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LogServiceImp implements LogService {
    @Autowired
    private UserAccountDao userAccountDao;

    @Autowired
    private LogsScrapRecordDao logsScrapRecordDao;

    @Autowired
    private LogsDao logsDao;

    @Autowired
    private LogsIdDao logsIdDao;

    @Autowired
    private LogsUserAccountDao logsUserAccountDao;

    @Autowired
    private DevIdDao devIdDao;

    @Autowired
    private DevWorkStatusDao devWorkStatusDao;

    @Autowired
    private LogsAddBasicRecordDao logsAddBasicRecordDao;

    @Autowired
    private LogsCancelRecord logsCancelRecord;

    @Autowired
    private UserAuthDao userAuthDao;

    @Autowired
    private LogsBuyTempDao logsBuyTempDao;

    @Autowired
    private DevBuyDao devBuyDao;

    @Autowired
    private LogUserAccountRepairDao logUserAccountRepairDao;

    @Autowired
    private LogUpdateDao logUpdateDao;

    @Override
    public List<Log> findAllLogs() {
        return logsDao.findAllLogs();
    }

    @Override
    public List<Log> findLogsByUserAccount(String userAccount) {
        return logsUserAccountDao.findLogsByUserAccount(userAccount);
    }

    public void addBasicRecord(String userAccount, Integer devId, int tokenId, int startStatus, int tokenStatus) throws Exception {
        String date = new Date().toString();
        Device device = devIdDao.findDeviceBydevId(devId).get(0);
        User user = userAuthDao.findUserByUserAuth(0).get(0);
        int deviceStatus = device.getDevStatus();
        int deviceWorkStatus = device.getDevWorkStatus();
        int auth = device.getDevAuth();
        if (!(device.getUserAccount() != null && device.getUserAccount().equals(userAccount))
                && !device.getManagerAccount().equals(userAccount)) {
            throw new Exception("Authentication failed " + userAccount);
        }
        if (deviceWorkStatus != startStatus) {
            throw new Exception("Can't deal device with devStatus:" + device.getDevWorkStatus());
        }
        if (tokenId == 5) {
            logsAddBasicRecordDao.logsAddBasicRecord(devId, deviceStatus, deviceWorkStatus,
                    tokenId, tokenStatus, userAccount, user.getUserAccount(), date, auth);
        } else {
            logsAddBasicRecordDao.logsAddBasicRecord(devId, deviceStatus, deviceWorkStatus,
                    tokenId, tokenStatus, userAccount, device.getManagerAccount(), date, auth);
        }
    }
/*
    @Override List<Log> addLendLog(String userAccount, Integer devId) throws Exception {
        addBasicRecord(userAccount, devId, 1, 1, 2, 1);
        return null;
    }
*/

    @Override
    public List<Log> addFixLog(String userAccount, Integer devId) throws Exception {
        addBasicRecord(userAccount, devId, 3, 3, 1);
        devWorkStatusDao.updateDevWorkStatusByDevId(devId, 1);
        return null;
    }

    @Override
    public List<Log> addDamageLog(String userAccount, Integer devId) throws Exception {
        addBasicRecord(userAccount, devId, 4, 1, 1);
        devWorkStatusDao.updateDevWorkStatusByDevId(devId, 3);
        return null;
    }

    @Override
    public List<Log> addScrapLog(String userAccount, Integer devId) throws Exception {
        checkLogOnce(userAccount,devId,5);
        addBasicRecord(userAccount, devId, 5, 3, 3);
        devWorkStatusDao.updateDevWorkStatusByDevId(devId, 5);
        return null;
    }

    @Override
    public List<Log> findScrapLog(String userAccount) throws Exception {
        int auth = userAccountDao.findUserByUserAccount(userAccount).get(0).getUserAuthority();
        if (auth > 0) {
            throw new Exception("Authentication failed with UserAuthority:" + auth);
        }
        return logsScrapRecordDao.findScrapRecord();
    }

    private Log checkLog(String userAccount, int logId, int logStatus, int minAuth) throws Exception {
        if (logStatus != 1 && logStatus != 2) {
            throw new Exception("logStatus only can be 1 or 2 but received:" + logStatus);
        }
        int userAuth = userAccountDao.findUserByUserAccount(userAccount).get(0).getUserAuthority();
        if (userAuth > minAuth) {
            throw new Exception("Authentication user failed with UserAuthority:" + userAuth);
        }
        Log log = logsIdDao.findLogsByLogId(logId).get(0);
        int logNowStatus = log.getTokenStatus();
        if (logNowStatus != 3) {
            throw new Exception("Authentication Log Status failed with:" + logNowStatus);
        }
        return log;
    }

    @Override
    public List<Log> dealScrapLog(String userAccount, Integer logId, Integer logStatus) throws Exception {
        String date = new Date().toString();
        Log log = checkLog(userAccount, logId, logStatus, 0);
        int devId = log.getDevId();
        logsScrapRecordDao.dealScrapRecord(logId, logStatus);
        devWorkStatusDao.updateDevWorkStatusByDevId(devId, logStatus == 2 ? 3 : 2);
        logsAddBasicRecordDao.logsAddBasicRecord(devId, -1, logStatus == 2 ? 3 : 2,
                6, logStatus, userAccount, "NULL", date, -1);
        return null;
    }

    @Override
    public List<Log> cancelRecord(String userAccount, Integer logId, Integer logStatus) throws Exception {
        if (logStatus == 4) {
            throw new Exception("This log has been canceled");
        }
        Log log = logsIdDao.findLogsByLogId(logId).get(0);
        int devId = log.getDevId();
        logsCancelRecord.cancelRecord(logId);
        devWorkStatusDao.updateDevWorkStatusByDevId(devId, 3);
        return null;
    }

    @Override
    public List<Log> findBuyDevTempLog(String userAccount) throws Exception {
        int auth = userAccountDao.findUserByUserAccount(userAccount).get(0).getUserAuthority();
        if (auth > 0) {
            throw new Exception("Authentication failed with UserAuthority:" + auth);
        }
        return logsBuyTempDao.findBuyTempRecord();
    }

    @Override
    public List<Log> dealBuyDevTempLog(String userAccount, String managerAccount, Integer logId, Integer logStatus) throws Exception {
        String date = new Date().toString();
        int userAuth = userAccountDao.findUserByUserAccount(userAccount).get(0).getUserAuthority();
        int managerAuth = userAccountDao.findUserByUserAccount(managerAccount).get(0).getUserAuthority();
        Log log = logsIdDao.findLogsByLogId(logId).get(0);
        int logNowStatus = log.getTokenStatus();
        int tempDevId = log.getDevId();
        List<Device> devices = devBuyDao.findTempDeviceBydevId(tempDevId);
        Device device = devices.get(0);
        int devId = devBuyDao.getPrimayKey() + 1;
        String devName = device.getDevName();
        String devType = device.getDevType();
        float devPrise = device.getDevPrise();
        String devDate = device.getDevDate();
        String devPeriod = device.getDevPeriod();
        String chargeAccount = device.getChargeAccount();
        int devAuth = device.getDevAuth();
        if (logStatus != 3) {
            throw new Exception("logStatus only can 3 but received:" + logStatus);
        }
        if (userAuth > 0) {
            throw new Exception("Authentication user failed with UserAuthority:" + userAuth);
        }
        if (managerAuth > 2) {
            throw new Exception("No such manager");
        }
        if (logNowStatus != 3) {
            throw new Exception("Authentication Log Status failed with:" + logNowStatus);
        }
        devBuyDao.buyDeviceByDevInfo(devId, devName, devType, devPrise, devDate, devPeriod, chargeAccount, managerAccount, devAuth);
        logsBuyTempDao.logUpdate(devId, logId, date);
        return null;
    }

    @Override
    public List<Log> findRepairLog(String userAccount) throws Exception {
        return logUserAccountRepairDao.findRepairLogByUserAccount(userAccount);
    }

    @Override
    public List<Log> dealRepairLog(String userAccount, Integer logId, Integer logStatus) throws Exception {
        Log log = checkLog(userAccount, logId, logStatus, 2);
        int devId = log.getDevId();
        logUpdateDao.updateByLogId(logId, logStatus);
        devWorkStatusDao.updateDevWorkStatusByDevId(devId, logStatus == 2 ? 3 : 1);
        return null;
    }

    public void checkLogOnce(String userAccount, Integer devId, Integer tokenId) throws Exception {
        List<Log> logs = logsUserAccountDao.findLogsByUser(userAccount,devId,3,tokenId);
        if (logs.size() > 0){
            throw new Exception("Can't add more than one log");
        }

    }

    @Override
    public List<Log> addRepairRecord(String userAccount, Integer devId) throws Exception {
        checkLogOnce(userAccount,devId,7);
        addBasicRecord(userAccount, devId, 7, 3, 3);
        return null;
    }

}
