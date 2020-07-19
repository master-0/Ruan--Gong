package org.spring.springboot.dao.users;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Mapper;
import org.spring.springboot.domain.User;

import java.util.List;

@Mapper
public interface UserAuthDao {
    @Select("SELECT * FROM users where user_authority = #{auth}")
    // 返回 Map 结果集
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "userAccount", column = "user_account"),
            @Result(property = "userPassword", column = "user_password"),
            @Result(property = "userAuthority", column = "user_authority")
    })
    List<User> findUserByUserAuth(@Param("auth") int auth);

}
