package org.spring.springboot.dao.attentions;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.spring.springboot.domain.AttentionItem;

import java.util.List;

public interface AttentionUserAccountAndDevIdDao {
    @Select("SELECT * FROM attentions where user_account = #{userAccount} and dev_id = #{devId}")
    @Results({
            @Result(property = "userAccount", column = "user_account"),
            @Result(property = "devId", column = "dev_id")
    })
    List<AttentionItem> findAttentionByUserAccountAndDevId(@Param("userAccount") String userAccount,
                                                   @Param("devId") int devId);
}
