package org.spring.springboot.dao.emails;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.spring.springboot.domain.Email;

import java.util.List;

public interface EmailUserAccountDao {
    @Select("SELECT * FROM emails where user_account = #{userAccount}")
    // 返回 Map 结果集
    @Results({
            @Result(property = "userAccount", column = "user_account"),
            @Result(property = "emailAddress", column = "email_address")
    })
    List<Email> findEmailByUserAccount(@Param("userAccount") String userAccount);
}
