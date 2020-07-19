package org.spring.springboot.controller;

import org.spring.springboot.service.ServiceImp.EmailClient;
import org.spring.springboot.ExceptionCatch;
import org.spring.springboot.ResultBean;
import org.spring.springboot.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    @Autowired
    EmailService emailService;

    @RequestMapping(value = "/api/EmailFindByUserAccount", method = RequestMethod.GET)
    public ResultBean findEmailByUserAccount(
            @RequestParam(value = "userAccount", required = true) String userAccount) {
        return ExceptionCatch.exceptionCatch(emailService, userAccount, userAccount);
    }

    @RequestMapping(value = "/api/EmailBind", method = RequestMethod.GET)
    public ResultBean bindEmail(
            @RequestParam(value = "userAccount", required = true) String userAccount,
            @RequestParam(value = "userPassword", required = true) String userPassword,
            @RequestParam(value = "emailAddress", required = true) String emailAddress) {
        return ExceptionCatch.exceptionCatch(emailService, userAccount, userAccount, userPassword, emailAddress);
    }

    @RequestMapping(value = "/api/EmailUpdate", method = RequestMethod.GET)
    public ResultBean updateEmail(
            @RequestParam(value = "userAccount", required = true) String userAccount,
            @RequestParam(value = "userPassword", required = true) String userPassword,
            @RequestParam(value = "emailAddress", required = true) String emailAddress) {
        return ExceptionCatch.exceptionCatch(emailService, userAccount, userAccount, userPassword, emailAddress);
    }

    @RequestMapping(value = "/api/EmailUnbind", method = RequestMethod.GET)
    public ResultBean unbindEmail(
            @RequestParam(value = "userAccount", required = true) String userAccount,
            @RequestParam(value = "userPassword", required = true) String userPassword) {
        return ExceptionCatch.exceptionCatch(emailService, userAccount,  userAccount, userPassword);
    }

}
