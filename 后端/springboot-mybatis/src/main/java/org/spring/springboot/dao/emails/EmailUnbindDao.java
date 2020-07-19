package org.spring.springboot.dao.emails;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

public interface EmailUnbindDao {
    @Delete("DELETE FROM emails where user_account = #{userAccount}")
    void unbindEmailAddress(@Param("userAccount") String userAccount);
}
