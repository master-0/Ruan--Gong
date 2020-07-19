package RegressionTest;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.spring.springboot.Application;
import org.spring.springboot.RegressionTest;
import org.spring.springboot.ResultBean;
import org.spring.springboot.controller.DeviceController;
import org.spring.springboot.controller.LogController;
import org.spring.springboot.controller.UserController;
import org.spring.springboot.dao.devices.DevBuyDao;
import org.spring.springboot.dao.devices.DevWorkStatusDao;
import org.spring.springboot.domain.Device;
import org.spring.springboot.domain.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LogControllerJunitTest {
    @Autowired
    LogController logController;

    @Autowired
    DevWorkStatusDao devWorkStatusDao;

    @Autowired
    DeviceController deviceController;

    @Autowired
    DevBuyDao devBuyDao;

    @BeforeClass
    public static void setTestInfo() {
        RegressionTest.setTestInfo("---test.LogControllerJunitTest---:");
    }

    @Before
    public void TestBefore() {
        System.out.println("LogController Test Start:");
    }

    @Test
    public void Test001_findAllLogs() {
        ResultBean<Log> logs = logController.findAllLogs();
        assertEquals(0, logs.getCode());
    }

    @Test
    public void Test002_findLogsByUserId() {
//        ResultBean<Log> logs = logController.findLogsByUserAccount("-1");
//        assertEquals(0, logs.getCode());
//        assertEquals(1, logs.getData().size());
    }

    @Test
    public void Test003_addFixLog() {
        ResultBean addFixDamageWorkStatusError = logController.addDamageLog("TestUserAccount", -1);
        assertEquals(0, addFixDamageWorkStatusError.getCode());

        ResultBean addFixLogAuthError = logController.addFixLog("AAedion", -1);
        assertEquals("Authentication failed AAedion", addFixLogAuthError.getMessage());
        assertEquals(-1, addFixLogAuthError.getCode());
        assertEquals(null, addFixLogAuthError.getData());

        addFixDamageWorkStatusError = logController.addDamageLog("TestUserAccount", -1);
        assertEquals(-1, addFixDamageWorkStatusError.getCode());
        assertEquals(null, addFixDamageWorkStatusError.getData());
        assertEquals("Can't deal device with devStatus:3", addFixDamageWorkStatusError.getMessage());

        ResultBean addFixLog = logController.addFixLog("TestUserAccount", -1);
        assertEquals(0, addFixLog.getCode());
        assertEquals(null, addFixLog.getData());
        assertEquals("success", addFixLog.getMessage());
    }

    @Test
    public void Test004_addDamageLog() {
        ResultBean addDamageLogAuthError = logController.addDamageLog("AAedion", -1);
        assertEquals(-1, addDamageLogAuthError.getCode());
        assertEquals(null, addDamageLogAuthError.getData());
        assertEquals("Authentication failed AAedion", addDamageLogAuthError.getMessage());

        ResultBean addFixLogWorkStatusError = logController.addFixLog("TestUserAccount", -1);
        assertEquals(-1, addFixLogWorkStatusError.getCode());
        assertEquals(null, addFixLogWorkStatusError.getData());
        assertEquals("Can't deal device with devStatus:1", addFixLogWorkStatusError.getMessage());

        ResultBean addDamageLog = logController.addDamageLog("TestUserAccount", -1);
        assertEquals(0, addDamageLog.getCode());
        assertEquals(null, addDamageLog.getData());
        assertEquals("success", addDamageLog.getMessage());
    }

    @Test
    public void Test005_addScrapRecord() {
        ResultBean addScrapLogAuthError = logController.addScrapLog("AAedion", -1);
        assertEquals(-1, addScrapLogAuthError.getCode());
        assertEquals(null, addScrapLogAuthError.getData(), null);
        assertEquals("Authentication failed AAedion", addScrapLogAuthError.getMessage());

        ResultBean addScrapLog = logController.addScrapLog("TestUserAccount", -1);
        assertEquals("success", addScrapLog.getMessage());
        assertEquals(0, addScrapLog.getCode());
        assertEquals(null, addScrapLog.getData());

        ResultBean scrapLog = logController.findScrapLog("TestUserAccount");
        assertEquals(0, scrapLog.getCode());
        assertEquals("success", scrapLog.getMessage());
        int logId = new ArrayList<Log>(scrapLog.getData()).get(0).getLogId();


        ResultBean dealScrapLog = logController.dealScrapLog("TestUserAccount", logId, 1);
        assertEquals(0, dealScrapLog.getCode());
        assertEquals(null, dealScrapLog.getData());
        assertEquals("success", dealScrapLog.getMessage());

        devWorkStatusDao.updateDevWorkStatusByDevId(-1, 3);

        addScrapLog = logController.addScrapLog("TestUserAccount", -1);
        assertEquals(0, addScrapLog.getCode());
        assertEquals(null, addScrapLog.getData());
        assertEquals("success", addScrapLog.getMessage());
    }

    @Test
    public void Test006_findScrapRecord() {
        ResultBean scrapLog = logController.findScrapLog("TestUserAccount");
        assertEquals(0, scrapLog.getCode());
        assertEquals("success", scrapLog.getMessage());
    }

    @Test
    public void Test007_dealScrapRecord() {
        ResultBean scrapLog = logController.findScrapLog("TestUserAccount");
        int logId = new ArrayList<Log>(scrapLog.getData()).get(0).getLogId();

        ResultBean dealScrapLog = logController.dealScrapLog("TestUserAccount", logId, 2);
        assertEquals("success", dealScrapLog.getMessage());
        assertEquals(null, dealScrapLog.getData());
        assertEquals(0, dealScrapLog.getCode());

        ResultBean<Device> device = deviceController.findDeviceByDevId(-1);
        Device dev = new ArrayList<Device>(device.getData()).get(0);
        assertEquals(0, device.getCode());
        assertEquals(3, dev.getDevWorkStatus());

        ResultBean addFixLog = logController.addFixLog("TestUserAccount", -1);
        assertEquals(0, addFixLog.getCode());
        assertEquals(null, addFixLog.getData());
        assertEquals("success", addFixLog.getMessage());
    }

    @Test
    public void Test008_findBuyDevTempLog() {
        ResultBean buyDevTempLog = logController.findBuyDevTempLog("TestUserAccount");
        assertEquals(0, buyDevTempLog.getCode());
        assertEquals("success", buyDevTempLog.getMessage());
    }

    @Test
    public void Test009_dealBuyDevTempLog() {
        ResultBean buyDevTempLog = logController.findBuyDevTempLog("TestUserAccount");
        int logId = new ArrayList<Log>(buyDevTempLog.getData()).get(0).getLogId();
        int logStatus = new ArrayList<Log>(buyDevTempLog.getData()).get(0).getTokenStatus();
        ResultBean dealBuyDevTempLog = logController.dealBuyDevTempLog("TestUserAccount","TestUserAccount",logId,logStatus);
        assertEquals(null, dealBuyDevTempLog.getData());
        assertEquals(0, dealBuyDevTempLog.getCode());
        assertEquals("success", dealBuyDevTempLog.getMessage());
        int devId = devBuyDao.getTempPrimayKey();
        devBuyDao.delDevTemp(devId);
        int devTempId = devBuyDao.getPrimayKey();
        devBuyDao.delDev(devTempId);
    }

    @Test
    public void Test010_addRepairRecord() {
        ResultBean devLend = deviceController.lendDeviceByDevId("TestUserAccount",-1);
        assertEquals(0,devLend.getCode());

        ResultBean addFixDamageWorkStatusError = logController.addDamageLog("TestUserAccount", -1);
        assertEquals(0, addFixDamageWorkStatusError.getCode());

        ResultBean addRepairRecord = logController.addRepairRecord("TestUserAccount", -1);
        assertEquals(0,addRepairRecord.getCode());
        assertEquals(null,addRepairRecord.getData());
        assertEquals("success",addRepairRecord.getMessage());
    }

    @Test
    public void Test011_findRepairLog() {
        ResultBean findRepairLog = logController.findRepairLog("TestUserAccount");
        assertEquals(0,findRepairLog.getCode());
        assertEquals("success",findRepairLog.getMessage());
        assertNotNull(findRepairLog.getData());
    }

    @Test
    public void Test012_dealRepairLog() {
        ResultBean findRepairLog = logController.findRepairLog("TestUserAccount");
        assertEquals(0,findRepairLog.getCode());

        int logId = new ArrayList<Log>(findRepairLog.getData()).get(0).getLogId();
        ResultBean dealRepairLog = logController.dealRepairLog("TestUserAccount",logId,1);
        assertEquals(0,dealRepairLog.getCode());
        assertEquals("success",dealRepairLog.getMessage());
        assertEquals(null,dealRepairLog.getData());

        ResultBean revertDev = deviceController.revertDeviceByDevId("TestUserAccount",-1);
        assertEquals(0,revertDev.getCode());
        assertEquals("success",revertDev.getMessage());
    }


    @After
    public void testAfter() {
        System.out.println("LogController Test End:");
    }
}
