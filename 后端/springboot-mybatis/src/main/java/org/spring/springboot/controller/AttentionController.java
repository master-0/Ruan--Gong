package org.spring.springboot.controller;

import org.spring.springboot.ExceptionCatch;
import org.spring.springboot.ResultBean;
import org.spring.springboot.service.AttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AttentionController {
    @Autowired
    AttentionService attentionService;

    // add attention record
    @RequestMapping(value = "api/AttentionAddRecord", method = RequestMethod.GET)
    public ResultBean addAttentionRecord(
            @RequestParam(value = "userAccount", required = true) String userAccount,
            @RequestParam(value = "devId", required = true) Integer devId
    ) {
        return ExceptionCatch.exceptionCatch(attentionService, userAccount, userAccount,devId);
    }

    @RequestMapping(value = "api/AttentionCancelRecord", method = RequestMethod.GET)
    public ResultBean cancelAttentionRecord(
            @RequestParam(value = "userAccount", required = true) String userAccount,
            @RequestParam(value = "devId", required = true) Integer devId
    ) {
        return ExceptionCatch.exceptionCatch(attentionService, userAccount, userAccount,devId);
    }

    @RequestMapping(value = "api/AttentionFindRecord", method = RequestMethod.GET)
    public ResultBean FindAttentionRecord(
            @RequestParam(value = "userAccount", required = true) String userAccount
    ) {
        return ExceptionCatch.exceptionCatch(attentionService, userAccount, userAccount);
    }

    @RequestMapping(value = "api/AttentionDevices", method = RequestMethod.GET)
    public ResultBean FindAttentionDevices(
            @RequestParam(value = "userAccount", required = true) String userAccount
    ) {
        return ExceptionCatch.exceptionCatch(attentionService, userAccount, userAccount);
    }
}
