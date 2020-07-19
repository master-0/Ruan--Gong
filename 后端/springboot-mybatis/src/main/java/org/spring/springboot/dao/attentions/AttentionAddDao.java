package org.spring.springboot.dao.attentions;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface AttentionAddDao {
    @Insert("insert into attentions value(#{userAccount}, #{devId})")
    void addAttention(@Param("userAccount") String userAccount, @Param("devId") int devId);
}
