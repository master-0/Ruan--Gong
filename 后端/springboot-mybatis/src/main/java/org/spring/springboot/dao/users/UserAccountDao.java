package org.spring.springboot.dao.users;


import org.apache.ibatis.annotations.*;
import org.spring.springboot.domain.User;

import java.util.List;

@Mapper
public interface UserAccountDao {
    @Select("SELECT * FROM users where user_account = #{userAccount}")
    // 返回 Map 结果集
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "userAccount", column = "user_account"),
            @Result(property = "userPassword", column = "user_password"),
            @Result(property = "userAuthority", column = "user_authority")
    })
    List<User> findUserByUserAccount(@Param("userAccount") String userAccount);
}
