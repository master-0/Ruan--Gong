package org.spring.springboot.dao.users;

import org.apache.ibatis.annotations.*;

@Mapper
public interface UserUpdatePassword {
    @Select("select Count(*) from users where user_account = #{userAccount} and user_password = #{userOldPassword} limit 1")
    @ResultType(Integer.class)
    int isPasswordRight(@Param("userAccount") String userAccount, @Param("userOldPassword") String userOldPassword);

    @Update("update users set user_password = #{userNewPassword} where user_account = #{userAccount}")
    void userUpdatePassword(@Param("userAccount") String userAccount,
                            @Param("userNewPassword") String userNewPassword);
}
