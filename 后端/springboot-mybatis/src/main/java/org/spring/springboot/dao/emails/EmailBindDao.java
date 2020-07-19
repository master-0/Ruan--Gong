package org.spring.springboot.dao.emails;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface EmailBindDao {
    @Insert("insert into emails value(#{userAccount}, #{emailAddress})")
    void bindEmailAddress(@Param("userAccount") String userAccount,
                          @Param("emailAddress") String emailAddress);
}
