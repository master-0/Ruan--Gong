package org.spring.springboot.service;

import org.spring.springboot.domain.User;

import java.util.List;

public interface UserService extends Service {
    List<User> findUserByUserAccount(String userId) throws Exception;

    List<User> findUserByUserId(Integer userId) throws Exception;

    List<User> userSignUp(Integer userId, String userAccount, String userName, String userPassword, Integer auth) throws Exception;

    List<User> userSignUp(String userAccount, String userName, String userPassword) throws Exception;

    List<User> userSignUp(String userAccount, String userPassword) throws Exception;

    List<User> login(String userAccount, String userPassword) throws Exception;

    List<User> userUpdatePassword(String userAccount, String userOldPassword, String userNewPassword) throws Exception;

    List<User> userLogout(String userAccount, String userPassword) throws Exception;

    List<User> findUserByUserAuth(Integer userAuth) throws Exception;
}
