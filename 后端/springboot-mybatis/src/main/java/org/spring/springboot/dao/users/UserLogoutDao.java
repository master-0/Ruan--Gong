package org.spring.springboot.dao.users;

import org.apache.ibatis.annotations.*;

public interface UserLogoutDao {
    @Delete("DELETE FROM users where user_account = #{userAccount}")
    void userLogout(@Param("userAccount") String userAccount);
}
