package org.spring.springboot.controller;

import org.spring.springboot.ExceptionCatch;
import org.spring.springboot.ResultBean;
import org.spring.springboot.domain.User;
import org.spring.springboot.service.ServiceImp.EmailClient;
import org.spring.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    // find userInfo by userAccount
    @RequestMapping(value = "/api/userAccount", method = RequestMethod.GET)
    public ResultBean<User> findUserByUserAccount(@RequestParam(value = "userAccount", required = true) String userAccount) throws RuntimeException {
        return ExceptionCatch.exceptionCatch(userService, userAccount, userAccount);
    }

    //  find userInfo by userId
    @RequestMapping(value = "/api/userId", method = RequestMethod.GET)
    public ResultBean<User> findUserByUserId(@RequestParam(value = "userId", required = true) Integer userId) throws RuntimeException {
        return ExceptionCatch.exceptionCatch(userService, userId.toString(), userId);
    }

    // find userInfo by userAuth
    @RequestMapping(value = "/api/userAuth", method = RequestMethod.GET)
    public ResultBean<User> findUserByUserAuth(@RequestParam(value = "userAuth", required = true) Integer userAuth) throws RuntimeException {
        return ExceptionCatch.exceptionCatch(userService, userAuth.toString(), userAuth);
    }

    //  login
    @RequestMapping(value = "/api/login", method = RequestMethod.GET)
    public ResultBean login(@RequestParam(value = "userAccount", required = true) String userAccount,
                            @RequestParam(value = "userPassword", required = true) String userPassword) {
        return ExceptionCatch.exceptionCatch(userService, userAccount, userAccount, userPassword);
    }
    // register

    /**
     * The legality of password should checked in mid
     * just check the legality of userAccount legality
     */
    @RequestMapping(value = "/api/register", method = RequestMethod.GET)
    public ResultBean userSignUp(@RequestParam(value = "userAccount", required = true) String userAccount,
                                 @RequestParam(value = "userName", required = true) String userName,
                                 @RequestParam(value = "userPassword", required = true) String userPassword) {
        return ExceptionCatch.exceptionCatch(userService, userAccount, userAccount, userName, userPassword);
    }

    @RequestMapping(value = "/api/registerTest", method = RequestMethod.GET)
    public ResultBean userSignUp(@RequestParam(value = "userId", required = true) Integer userId,
                                 @RequestParam(value = "userAccount", required = true) String userAccount,
                                 @RequestParam(value = "userName", required = true) String userName,
                                 @RequestParam(value = "userPassword", required = true) String userPassword,
                                 @RequestParam(value = "userAuth", required = true) Integer userAuth) {
        return ExceptionCatch.exceptionCatch(userService, userAccount, userId, userAccount, userName, userPassword, userAuth);
    }

    //  update user password
    @RequestMapping(value = "/api/userUpdatePassword", method = RequestMethod.GET)
    public ResultBean userUpdatePassword(@RequestParam(value = "userAccount", required = true) String userAccount,
                                         @RequestParam(value = "userOldPassword", required = true) String userOldPassword,
                                         @RequestParam(value = "userNewPassword", required = true) String userNewPassword) {
        return ExceptionCatch.exceptionCatch(userService, userAccount, userAccount, userOldPassword, userNewPassword);
    }

    //  logout
    @RequestMapping(value = "/api/logout", method = RequestMethod.GET)
    public ResultBean userLogout(@RequestParam(value = "userAccount", required = true) String userAccount,
                                 @RequestParam(value = "userPassword", required = true) String userPassword) {
        return ExceptionCatch.exceptionCatch(userService, userAccount, userAccount, userPassword);
    }

    @Autowired
    EmailClient emailClient;
    @RequestMapping(value = "/api/send", method = RequestMethod.GET)
    public void sendmail(){
        emailClient.sendMail("296684505@qq.com","text","text");
    }
}


