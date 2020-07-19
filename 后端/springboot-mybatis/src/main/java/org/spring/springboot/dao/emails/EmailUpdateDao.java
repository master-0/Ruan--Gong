package org.spring.springboot.dao.emails;

import org.apache.ibatis.annotations.*;
import org.spring.springboot.domain.Device;
import org.spring.springboot.domain.Email;

import java.util.List;

public interface EmailUpdateDao {
    @Update("update emails set email_address = #{emailAddress} where user_account = #{userAccount}")
    void updateEmailAddress(@Param("userAccount") String userAccount,
                           @Param("emailAddress") String emailAddress);
}
