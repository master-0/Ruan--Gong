package RegressionTest;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.spring.springboot.Application;
import org.spring.springboot.RegressionTest;
import org.spring.springboot.ResultBean;
import org.spring.springboot.controller.AttentionController;
import org.spring.springboot.controller.DeviceController;
import org.spring.springboot.controller.LogController;
import org.spring.springboot.dao.devices.DevBuyDao;
import org.spring.springboot.domain.AttentionItem;
import org.spring.springboot.domain.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeviceControllerJunitTest {


    @Autowired
    DeviceController deviceController;
    @Autowired
    LogController logController;
    @Autowired
    DevBuyDao devBuyDao;
    @Autowired
    AttentionController attentionController;

    @BeforeClass
    public static void setTestInfo() {
        RegressionTest.setTestInfo("---test.DeviceControllerJunitTest---:");
    }

    @Before
    public void TestBefore() {
        System.out.println("DeviceController Test Start:");
    }

    @Test
    public void Test001_findDeviceByDevId() {
        // find devInfo by devId
        ResultBean<Device> findDeviceByDeviceId = deviceController.findDeviceByDevId(-1);
        ArrayList<Device> device = new ArrayList<Device>(findDeviceByDeviceId.getData());
        assertEquals(0, findDeviceByDeviceId.getCode());
        assertEquals("success", findDeviceByDeviceId.getMessage());
        assertEquals(1, device.size());
        assertEquals(true, device.get(0).getDevName().equals("TestDevName"));
        assertEquals(true, device.get(0).getDevType().equals("TestDevType"));
        assertEquals(true, device.get(0).getDevPrise() == 0.0);
        assertEquals(true, device.get(0).getDevDate().equals("Fri May 29 10:06:15 UTC 2020"));
        assertEquals(true, device.get(0).getDevPeriod().equals("TestDevPeriod"));
        assertEquals(true, device.get(0).getChargeAccount().equals("TestChargeAccount"));
        assertEquals(true, device.get(0).getManagerAccount().equals("TestUserAccount"));
        assertEquals(true, device.get(0).getDevWorkStatus() == 1);
        assertEquals(true, device.get(0).getDevStatus() == 1);
        assertEquals(true, device.get(0).getDevAuth() == 0);
    }

    @Test
    public void Test002_findDeviceByManagerAccount() {
        ResultBean<Device> findDeviceByManagerAccount = deviceController.findDeviceByManagerAccount("TestManagerAccount");
        assertEquals(0, findDeviceByManagerAccount.getCode());
        assertEquals("success", findDeviceByManagerAccount.getMessage());
        assertNotNull(findDeviceByManagerAccount.getData());
    }

    @Test
    public void Test003_findDeviceByDevAuth() {
        ResultBean<Device> findDeviceByDevAuth = deviceController.findDeviceByDevAuth(0);
        assertEquals(0, findDeviceByDevAuth.getCode());
        assertEquals("success", findDeviceByDevAuth.getMessage());
        assertNotNull(findDeviceByDevAuth.getData());
    }

    @Test
    public void Test004_findDeviceByUserAccount() {
        ResultBean<Device> findDeviceByUserAccount = deviceController.findDeviceByUserAccount("22233");
        assertEquals(-1, findDeviceByUserAccount.getCode());
        assertEquals("userAccount not exist in DataBase", findDeviceByUserAccount.getMessage());
        assertNull(findDeviceByUserAccount.getData());
    }

    @Test
    public void Test005_lendDeviceByDevId() {
        ResultBean<Device> lendDeviceByDevId = deviceController.lendDeviceByDevId("TestUserAccount", -1);
        assertEquals(0, lendDeviceByDevId.getCode());

        lendDeviceByDevId = deviceController.lendDeviceByDevId("TestUserAccount", -1);
        assertEquals(-1, lendDeviceByDevId.getCode());
        assertEquals("Device can not be lend to you", lendDeviceByDevId.getMessage());
        assertNull(lendDeviceByDevId.getData());
    }

    @Test
    public void Test006_findDeviceByDevUserAccount() {
        ResultBean<Device> findDeviceByDevUserAccount = deviceController.findDeviceByDevUserAccount("TestUserAccount");
        assertEquals(0, findDeviceByDevUserAccount.getCode());
        assertEquals("success", findDeviceByDevUserAccount.getMessage());
        assertNotNull(findDeviceByDevUserAccount.getData());
    }

    @Test
    public void Test007_revertDeviceByDevId() {
        ResultBean<AttentionItem> addAttention = attentionController
                .addAttentionRecord("TestUserAccount", -1);
        assertEquals(0, addAttention.getCode());

        ResultBean<Device> revertDeviceByDevId = deviceController.revertDeviceByDevId("TestUserAccount", -1);
        assertEquals("success", revertDeviceByDevId.getMessage());
        assertEquals(0, revertDeviceByDevId.getCode());

        ResultBean<AttentionItem> cancelAttention = attentionController
                .cancelAttentionRecord("TestUserAccount",-1);
        assertEquals("success", cancelAttention.getMessage());
        assertEquals(0, cancelAttention.getCode());

        revertDeviceByDevId = deviceController.revertDeviceByDevId("TestUserAccount", -1);
        assertEquals(-1, revertDeviceByDevId.getCode());
        assertEquals("Device can not be reverted", revertDeviceByDevId.getMessage());
        assertNull(revertDeviceByDevId.getData());
    }

    @Test
    public void Test008_buyDeviceByDevInfo() {
        ResultBean<Device> buyDeviceByDevInfo = deviceController.buyDeviceByDevInfo("newDevName","newDevType",100,
                "newDevPeriod","Charge","Manager1",3,1);
        assertEquals(0,buyDeviceByDevInfo.getCode());
        assertEquals("success",buyDeviceByDevInfo.getMessage());
        assertNotNull(buyDeviceByDevInfo.getData());
        int devId = devBuyDao.getPrimayKey();
        devBuyDao.delDev(devId);
    }

    @Test
    public void Test009_buyDeviceTempByDevInfo() {
        ResultBean<Device> buyDeviceTempByDevInfo = deviceController.buyDeviceTempByDevInfo("newDevName","newDevType",100,
                "newDevPeriod","TestUserAccount",3,1);
        assertEquals(0,buyDeviceTempByDevInfo.getCode());
        assertEquals("success",buyDeviceTempByDevInfo.getMessage());
        assertNull(buyDeviceTempByDevInfo.getData());

    }

    @Test
    public void Test010_findTemp() {
        ResultBean<Device> findTemp = deviceController.findTemp(-1);
        assertEquals(0,findTemp.getCode());
        assertEquals("success",findTemp.getMessage());
        assertNotNull(findTemp.getData());
    }
    

    @After
    public void testAfter() {
        System.out.println("DeviceController Test End:");
    }
}