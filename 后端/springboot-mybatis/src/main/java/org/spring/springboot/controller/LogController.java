package org.spring.springboot.controller;

import org.spring.springboot.ExceptionCatch;
import org.spring.springboot.ResultBean;
import org.spring.springboot.domain.Log;
import org.spring.springboot.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {
    @Autowired
    private LogService logService;

    //  find all logs
    @RequestMapping(value = "/api/logs", method = RequestMethod.GET)
    public ResultBean<Log> findAllLogs() {
        return ExceptionCatch.exceptionCatch(logService, "AllLogs");
    }

    //  find logs by userAccount
    @RequestMapping(value = "/api/userLogs", method = RequestMethod.GET)
    public ResultBean<Log> findLogsByUserAccount(@RequestParam(value = "userAccount", required = true) String userAccount) {
        return ExceptionCatch.exceptionCatch(logService, userAccount, userAccount);
    }

    // add Fix record
    @RequestMapping(value = "/api/devAddFixRecord", method = RequestMethod.GET)
    public ResultBean addFixLog(
            @RequestParam(value = "userAccount", required = true) String userAccount,
            @RequestParam(value = "devId", required = true) Integer devId
    ) {
        return ExceptionCatch.exceptionCatch(logService, devId.toString(), userAccount, devId);
    }

    // add damage record
    @RequestMapping(value = "/api/devAddDamageRecord", method = RequestMethod.GET)
    public ResultBean addDamageLog(
            @RequestParam(value = "userAccount", required = true) String userAccount,
            @RequestParam(value = "devId", required = true) Integer devId
    ) {
        return ExceptionCatch.exceptionCatch(logService, devId.toString(), userAccount, devId);
    }

    // add scrapped record
    @RequestMapping(value = "/api/devAddScrapRecord", method = RequestMethod.GET)
    public ResultBean addScrapLog(
            @RequestParam(value = "userAccount", required = true) String userAccount,
            @RequestParam(value = "devId", required = true) Integer devId
    ) {
        return ExceptionCatch.exceptionCatch(logService, devId.toString(), userAccount, devId);
    }

    // find scrap record
    @RequestMapping(value = "/api/devFindScrapRecord", method = RequestMethod.GET)
    public ResultBean findScrapLog(
            @RequestParam(value = "userAccount", required = true) String userAccount
    ) {
        return ExceptionCatch.exceptionCatch(logService, userAccount, userAccount);
    }

    // find scrap record
    @RequestMapping(value = "/api/devDealScrapRecord", method = RequestMethod.GET)
    public ResultBean dealScrapLog(
            @RequestParam(value = "userAccount", required = true) String userAccount,
            @RequestParam(value = "logId", required = true) Integer logId,
            @RequestParam(value = "logStatus", required = true) Integer logStatus
    ) {
        return ExceptionCatch.exceptionCatch(logService, logId.toString(), userAccount, logId, logStatus);
    }

    // cancel record
    @RequestMapping(value = "api/logCancelRecord", method = RequestMethod.GET)
    public ResultBean cancelRecord(
            @RequestParam(value = "userAccount", required = true) String userAccount,
            @RequestParam(value = "logId", required = true) Integer logId,
            @RequestParam(value = "logStatus", required = true) Integer logStatus
    ) {
        return ExceptionCatch.exceptionCatch(logService, logId.toString(), userAccount, logId, logStatus);
    }

    // find buyDevTemp record
    @RequestMapping(value = "/api/logFindBuyTempRecord", method = RequestMethod.GET)
    public ResultBean findBuyDevTempLog(
            @RequestParam(value = "userAccount", required = true) String userAccount
    ) {
        return ExceptionCatch.exceptionCatch(logService, userAccount, userAccount);
    }

    // deal buyDevTemp record
    @RequestMapping(value = "/api/logDealBuyTempRecord", method = RequestMethod.GET)
    public ResultBean dealBuyDevTempLog(
            @RequestParam(value = "userAccount", required = true) String userAccount,
            @RequestParam(value = "managerAccount", required = true) String managerAccount,
            @RequestParam(value = "logId", required = true) Integer logId,
            @RequestParam(value = "logStatus", required = true) Integer logStatus
    ) {
        return ExceptionCatch.exceptionCatch(logService, logId.toString(), userAccount, managerAccount, logId, logStatus);
    }

    @RequestMapping(value = "/api/logFindRepairLog", method = RequestMethod.GET)
    public ResultBean findRepairLog(
            @RequestParam(value = "userAccount", required = true) String userAccount
    ) {
        return ExceptionCatch.exceptionCatch(logService, userAccount, userAccount);
    }

    @RequestMapping(value = "/api/logDealRepairLog", method = RequestMethod.GET)
    public ResultBean dealRepairLog(
            @RequestParam(value = "userAccount", required = true) String userAccount,
            @RequestParam(value = "logId", required = true) Integer logId,
            @RequestParam(value = "logStatus", required = true) Integer logStatus
    ) {
        return ExceptionCatch.exceptionCatch(logService, userAccount, userAccount, logId, logStatus);
    }

    // add repair record
    @RequestMapping(value = "/api/logAddRepairRecord", method = RequestMethod.GET)
    public ResultBean addRepairRecord(
            @RequestParam(value = "userAccount", required = true) String userAccount,
            @RequestParam(value = "devId", required = true) Integer devId
    ) {
        return ExceptionCatch.exceptionCatch(logService, userAccount, userAccount, devId);
    }
}