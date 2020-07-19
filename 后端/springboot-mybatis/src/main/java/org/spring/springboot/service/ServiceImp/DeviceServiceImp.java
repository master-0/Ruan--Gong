package org.spring.springboot.service.ServiceImp;

import org.spring.springboot.HttpClient;
import org.spring.springboot.dao.attentions.AttentionDevIdDao;
import org.spring.springboot.dao.devices.*;
import org.spring.springboot.dao.emails.EmailUserAccountDao;
import org.spring.springboot.dao.logs.LogsAddBasicRecordDao;
import org.spring.springboot.dao.users.UserAccountDao;
import org.spring.springboot.dao.users.UserAuthDao;
import org.spring.springboot.domain.AttentionItem;
import org.spring.springboot.domain.Device;
import org.spring.springboot.domain.Email;
import org.spring.springboot.domain.User;
import org.spring.springboot.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Service
public class DeviceServiceImp implements DeviceService {
    @Autowired
    private DevIdDao devIdDao;
    @Autowired
    private DevManagerAccountDao devManagerAccountDao;

    @Autowired
    private DevAuthDao devAuthDao;

    @Autowired
    private UserAccountDao userAccountDao;

    @Autowired
    private DevRentDao devRentDao;

    @Autowired
    private DevUserAccountDao devUserAccountDao;

    @Autowired
    private DevRevertDao devRevertDao;

    @Autowired
    private DevBuyDao devBuyDao;

    @Autowired
    private LogsAddBasicRecordDao logsAddBasicRecordDao;

    @Autowired
    private UserAuthDao userAuthDao;

    @Autowired
    private AttentionDevIdDao attentionDevIdDao;

    @Autowired
    private EmailClient emailClient;

    @Autowired
    private EmailUserAccountDao emailUserAccountDao;

    public List<Device> findDeviceByDevId(Integer devId) throws Exception{
        List<Device> devices = devIdDao.findDeviceBydevId(devId);
        if(devices.size() == 0) throw new Exception("not found DeviceID");
        return devices;
    }

    public List<Device> findDeviceByManagerAccount(String managerAccount) {
        return devManagerAccountDao.findDeviceByManagerAccount(managerAccount);
    }

    public List<Device> findDeviceByDevAuth(Integer devAuth) {
        return devAuthDao.findDeviceByDevAuth(devAuth);
    }

    public List<Device> findDeviceByUserAccount(String userAccount) throws Exception {
        List<User> users = userAccountDao.findUserByUserAccount(userAccount);
        if (users.size() == 1) {
            User user = users.get(0);
            int auth = user.getUserAuthority();
            List<Device> authDevices = findDeviceByDevAuth(auth);
            List<Device> ownDevices = findDeviceByManagerAccount(userAccount);
            authDevices.addAll(ownDevices);
            return new ArrayList<>(new HashSet<>(authDevices));
        } else if (users.size() == 0) {
            throw new Exception("userAccount not exist in DataBase");
        } else {
            throw new Exception("Duplicate userAccount in DataBase");
        }
    }

    public List<Device> lendDeviceByDevId(String userAccount, Integer devId) throws Exception {
        List<User> users = userAccountDao.findUserByUserAccount(userAccount);
        List<Device> devices = devIdDao.findDeviceBydevId(devId);
        if (users.size() == 1 && devices.size() == 1) {
            Device device = devices.get(0);
            int devWorkStatus = device.getDevWorkStatus();
            int devStatus = device.getDevStatus();
            if (devWorkStatus == 1 && devStatus == 1) {
                devRentDao.lendDeviceByDevId(userAccount, devId);
                return devIdDao.findDeviceBydevId(devId);
            } else {
                throw new Exception("Device can not be lend to you");
            }
        } else {
            throw new Exception("Wrong userAccount or devId");
        }
    }

    public List<Device> revertDeviceByDevId(String userAccount, Integer devId) throws Exception {
        List<User> users = userAccountDao.findUserByUserAccount(userAccount);
        List<Device> devices = devIdDao.findDeviceBydevId(devId);
        if (users.size() == 1 && devices.size() == 1) {
            Device device = devices.get(0);
            int devStatus = device.getDevStatus();
            String devUserAccount = device.getUserAccount();
            if (devStatus == 2 && devUserAccount.equals(userAccount)) {
                devRevertDao.revertDeviceByDevId(devId);
                List<AttentionItem> attentionItemList = attentionDevIdDao.findAttentionByDevId(devId);
                for(AttentionItem item : attentionItemList){
                    String attentionUserAccount = item.getUserAccount();
                    System.out.println(attentionUserAccount);
                    List<Email> emails = emailUserAccountDao.findEmailByUserAccount(attentionUserAccount);
                    if(emails.size() == 0){
                        HttpClient.record(userAccount + " unbind a Email");
                        continue;
                    }
                    String emailAddress = emails.get(0).getEmailAddress();
                    emailClient.sendMail(emailAddress,
                            "您关注的设备"+device.getDevName()+"当前处于空闲状态",
                            "时间:" + new Date());
                }
                return devIdDao.findDeviceBydevId(devId);
            } else {
                throw new Exception("Device can not be reverted");
            }
        } else {
            throw new Exception("Wrong userAccount or devId");
        }
    }

    public List<Device> findDeviceByDevUserAccount(String userAccount){
        return devUserAccountDao.findDeviceByDevUserAccount(userAccount);
    }

    public List<Device> buyDeviceByDevInfo(String devName, String devType, Float devPrise, String devPeriod,
                                           String chargeAccount, String managerAccount, Integer devAuth, Integer number) throws Exception {
        List<User> chargers = userAccountDao.findUserByUserAccount(chargeAccount);
        List<User> managers = userAccountDao.findUserByUserAccount(managerAccount);
        if (chargers.size() == 1 && managers.size() == 1) {
            User charger = chargers.get(0);
            User manager = managers.get(0);
            int chargerAuth = charger.getUserAuthority();
            int managerAuth = manager.getUserAuthority();
            if ((chargerAuth <= 1) && managerAuth <= 2){
                for (int i = 0; i <number; i++){
                    int id = devBuyDao.getPrimayKey() + 1;
                    String devDate = new Date().toString();
                    devBuyDao.buyDeviceByDevInfo(id,devName,devType,devPrise,devDate,devPeriod,chargeAccount,managerAccount,devAuth);
                }
                int id = devBuyDao.getPrimayKey();
                return devIdDao.findDeviceBydevId(id);
            }
            else {
                throw new Exception("Wrong charger or manager");
            }
        }
        else {
            throw new Exception("No such charger or manager");
        }
    }

    public List<Device> buyDeviceTempByDevInfo(String devName, String devType, Float devPrise, String devPeriod,
                                               String chargeAccount, Integer devAuth, Integer number) throws Exception {
        List<User> chargers = userAccountDao.findUserByUserAccount(chargeAccount);
        if (chargers.size() == 1) {
            String date = new Date().toString();
            User charger = chargers.get(0);
            User user = userAuthDao.findUserByUserAuth(0).get(0);
            int chargerAuth = charger.getUserAuthority();
            if (chargerAuth <= 1){
                for (int i = 0; i <number; i++){
                    int devId = devBuyDao.getTempPrimayKey() + 1;
                    String devDate = new Date().toString();
                    devBuyDao.buyDeviceTempByDevInfo(devId,devName,devType,devPrise,devDate,devPeriod,chargeAccount,devAuth);
                    int logId = logsAddBasicRecordDao.getPrimayKey() + 1;
                    logsAddBasicRecordDao.logsAddBasicRecord(devId,1,1,0,3,chargeAccount,
                            user.getUserAccount(),date,devAuth);
                }
                return null;
            }
            else {
                throw new Exception("Wrong charger");
            }
        }
        else {
            throw new Exception("No such charger");
        }
    }

    public List<Device> findTemp(Integer devId) throws Exception{
        List<Device> devices = devIdDao.findDeviceTempBydevId(devId);
        if(devices.size() == 0) {
            throw new Exception("No such dev in temp");
        }
        return devices;
    }

}
