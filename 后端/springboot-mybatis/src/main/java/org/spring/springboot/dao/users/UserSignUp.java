package org.spring.springboot.dao.users;

import org.apache.ibatis.annotations.*;

@Mapper
public interface UserSignUp {
    @Select("select user_id from users order by user_id desc limit 1")
    @ResultType(Integer.class)
    Integer getPrimayKey();

    @Select("select Count(*) from users where user_account = #{userAccount} limit 1")
    @ResultType(Integer.class)
    int isDulicate(@Param("userAccount") String userAccount);

    @Insert("insert into users value(#{userId}, #{userName}, #{userAccount}, #{userPassword}, 3)")
    void userSignUp(@Param("userId") int userId,
                    @Param("userAccount") String userAccount,
                    @Param("userName") String userName,
                    @Param("userPassword") String userPassword);

    @Insert("insert into users value(#{userId}, #{userName}, #{userAccount}, #{userPassword}, #{userAuth})")
    void userSignUpTest(@Param("userId") int userId,
                        @Param("userAccount") String userAccount,
                        @Param("userName") String userName,
                        @Param("userPassword") String userPassword,
                        @Param("userAuth") int auth);

}