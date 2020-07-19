package org.spring.springboot.dao.attentions;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

public interface AttentionsCancelByDevId {
    @Delete("DELETE FROM attentions where user_account = #{userAccount} and dev_id = #{devId}")
    void deleteAttentionsByDevId(@Param("userAccount") String userAccount, @Param("devId") int devId);
}
