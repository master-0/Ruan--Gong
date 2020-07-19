package org.spring.springboot.service;

import org.spring.springboot.domain.Email;

import java.util.List;

public interface EmailService extends Service {
    List<Email> bindEmail(String userAccount, String userPassword, String emailAddress) throws Exception;

    List<Email> unbindEmail(String userAccount, String userPassword) throws Exception;

    List<Email> findEmailByUserAccount(String userAccount) throws Exception;

    List<Email> updateEmail(String userAccount, String userPassword, String emailAddress) throws Exception;
}
