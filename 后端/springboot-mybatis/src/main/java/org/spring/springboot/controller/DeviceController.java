package org.spring.springboot.controller;

import org.spring.springboot.ExceptionCatch;
import org.spring.springboot.ResultBean;
import org.spring.springboot.domain.Device;
import org.spring.springboot.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    // find devInfo by devId
    @RequestMapping(value = "/api/devId", method = RequestMethod.GET)
    public ResultBean<Device> findDeviceByDevId(@RequestParam(value = "devId", required = true) Integer devId) {
        return ExceptionCatch.exceptionCatch(deviceService, devId.toString(), devId);
    }

    // find devInfo by ManagerAccount
    @RequestMapping(value = "/api/devManagerAccount", method = RequestMethod.GET)
    public ResultBean<Device> findDeviceByManagerAccount(@RequestParam(value = "managerAccount", required = true) String managerAccount) {
        return ExceptionCatch.exceptionCatch(deviceService, managerAccount, managerAccount);
    }

    // find devInfo by userAuth
    @RequestMapping(value = "/api/devAuth", method = RequestMethod.GET)
    public ResultBean<Device> findDeviceByDevAuth(@RequestParam(value = "devAuth", required = true) Integer devAuth) {
        return ExceptionCatch.exceptionCatch(deviceService, "devAuth:" + devAuth, devAuth);
    }

    // find devInfo by userAccount
    @RequestMapping(value = "/api/devUserAccount", method = RequestMethod.GET)
    public ResultBean<Device> findDeviceByUserAccount(@RequestParam(value = "userAccount", required = true) String userAccount) {
        return ExceptionCatch.exceptionCatch(deviceService, userAccount, userAccount);
    }

    //lend dev by devId
    @RequestMapping(value = "/api/devLend", method = RequestMethod.GET)
    public ResultBean<Device> lendDeviceByDevId(@RequestParam(value = "userAccount", required = true) String userAccount,
                                                @RequestParam(value = "devId", required = true) Integer devId) {
        return ExceptionCatch.exceptionCatch(deviceService, userAccount, userAccount, devId);
    }

    //find devInfo by devUserAccount
    @RequestMapping(value = "/api/devDevUserAccount", method = RequestMethod.GET)
    public ResultBean<Device> findDeviceByDevUserAccount(@RequestParam(value = "userAccount", required = true) String userAccount) {
        return ExceptionCatch.exceptionCatch(deviceService, userAccount, userAccount);
    }

    //revert dev by devId
    @RequestMapping(value = "/api/devRevert", method = RequestMethod.GET)
    public ResultBean<Device> revertDeviceByDevId(@RequestParam(value = "userAccount", required = true) String userAccount,
                                                  @RequestParam(value = "devId", required = true) Integer devId) {
        return ExceptionCatch.exceptionCatch(deviceService, userAccount, userAccount, devId);
    }

    //buy dev by devInfo
    @RequestMapping(value = "/api/devBuy", method = RequestMethod.GET)
    public ResultBean<Device> buyDeviceByDevInfo(@RequestParam(value = "devName", required = true) String devName,
                                                 @RequestParam(value = "devType", required = true) String devType,
                                                 @RequestParam(value = "devPrise", required = true) float devPrise,
                                                 @RequestParam(value = "devPeriod", required = true) String devPeriod,
                                                 @RequestParam(value = "chargeAccount", required = true) String chargeAccount,
                                                 @RequestParam(value = "managerAccount", required = true) String managerAccount,
                                                 @RequestParam(value = "devAuth", required = true) Integer devAuth,
                                                 @RequestParam(value = "number", required = true) Integer number) {
        return  ExceptionCatch.exceptionCatch(deviceService, chargeAccount, devName, devType, devPrise,
                                                devPeriod, chargeAccount, managerAccount, devAuth, number);
    }

    //buy dev by devInfo to temp
    @RequestMapping(value = "/api/devBuyTemp", method = RequestMethod.GET)
    public ResultBean<Device> buyDeviceTempByDevInfo(@RequestParam(value = "devName", required = true) String devName,
                                                     @RequestParam(value = "devType", required = true) String devType,
                                                     @RequestParam(value = "devPrise", required = true) float devPrise,
                                                     @RequestParam(value = "devPeriod", required = true) String devPeriod,
                                                     @RequestParam(value = "chargeAccount", required = true) String chargeAccount,
                                                     @RequestParam(value = "devAuth", required = true) Integer devAuth,
                                                     @RequestParam(value = "number", required = true) Integer number) {
        return  ExceptionCatch.exceptionCatch(deviceService, chargeAccount, devName, devType, devPrise,
                devPeriod, chargeAccount, devAuth, number);
    }

    // find dev by devInfo in temp
    @RequestMapping(value = "api/devFindTemp", method = RequestMethod.GET)
    public ResultBean<Device> findTemp(@RequestParam(value = "devId", required = true) Integer devId) {
        return ExceptionCatch.exceptionCatch(deviceService,devId + "", devId);
    }

}
