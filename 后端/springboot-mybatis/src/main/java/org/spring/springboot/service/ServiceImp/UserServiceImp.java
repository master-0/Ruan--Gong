package org.spring.springboot.service.ServiceImp;

import org.junit.Before;
import org.spring.springboot.dao.users.*;
import org.spring.springboot.domain.Email;
import org.spring.springboot.domain.User;
import org.spring.springboot.service.EmailService;
import org.spring.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserAccountDao userAccountDao;

    @Autowired
    private UserIdDao userIdDao;

    @Autowired
    private UserSignUp userSignUp;

    @Autowired
    private UserUpdatePassword userUpdatePassword;

    @Autowired
    private UserLogoutDao userLogout;

    @Autowired
    private UserAuthDao userAuthDao;

    @Autowired
    private EmailService emailService;

    @Autowired
    private EmailClient emailClient;

    @Override
    public List<User> findUserByUserAccount(String userAccount) throws Exception {
        List<User> users = userAccountDao.findUserByUserAccount(userAccount);
        if (users.size() == 0) throw new Exception("UserAccount not Exist in DataBase");
        return users;
    }

    @Override
    public List<User> findUserByUserId(Integer userId) throws Exception {
        List<User> users = userIdDao.findUserByUserId(userId);
        if (users.size() == 0) throw new Exception("UserId not Exist in DataBase");
        return users;
    }

    @Override
    public List<User> userSignUp(Integer userId, String userAccount, String userName, String userPassword, Integer auth) throws Exception {
        if (userSignUp.isDulicate(userAccount) == 1) throw new Exception("Duplicate-userName");
        userSignUp.userSignUpTest(userId, userAccount, userName, userPassword, auth);
        return findUserByUserAccount(userAccount);
    }

    @Override
    public List<User> userSignUp(String userAccount, String userName, String userPassword) throws Exception {
        if (userSignUp.isDulicate(userAccount) == 1) throw new Exception("Duplicate-userName");
        int id = userSignUp.getPrimayKey() + 1;
        userSignUp.userSignUp(id, userAccount, userName, userPassword);
        return findUserByUserAccount(userAccount);
    }

    @Override
    public List<User> userSignUp(String userAccount, String userPassword) throws Exception{
        if (userSignUp.isDulicate(userAccount) == 1) throw new Exception("Duplicate-userName");
        int id = userSignUp.getPrimayKey() + 1;
        userSignUp.userSignUp(id, userAccount, "user", userPassword);
        return findUserByUserAccount(userAccount);
    }

    @Override
    public List<User> login(String userAccount, String userPassword) throws Exception{
        List<User> userByUserAccount = findUserByUserAccount(userAccount);
        if(userByUserAccount.get(0).getUserPassword().equals(userPassword)){
//            List<Email> email = emailService.findEmailByUserAccount(userAccount);
//            if(email.size() > 0){
//                emailClient.sendMail(email.get(0).getEmailAddress(),
//                        "您的账号" + userAccount + "刚刚进行了登录操作",
//                        new Date().toString() + "若非本人操作，请及时修改密码");
//            }
            return userByUserAccount;
        }else{
            throw new Exception("Wrong password");
        }
    }

    @Override
    public List<User> userUpdatePassword(String userAccount, String userOldPassword, String userNewPassword) throws Exception{
        List<User> users = login(userAccount, userOldPassword);
        userUpdatePassword.userUpdatePassword(userAccount, userNewPassword);
        return findUserByUserAccount(userAccount);
    }

    @Override
    public List<User> userLogout(String userAccount, String userPassword) throws Exception{
        List<User> users = login(userAccount, userPassword);
        userLogout.userLogout(userAccount);
        return users;
    }

    @Override
    public List<User> findUserByUserAuth(Integer userAuth) throws Exception {
        List<User> users = userAuthDao.findUserByUserAuth(userAuth);
        if (users.size() == 0) throw new Exception("No such user with this auth");
        return users;
    }
}
