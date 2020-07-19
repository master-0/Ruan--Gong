package org.spring.springboot.dao.attentions;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.spring.springboot.domain.AttentionItem;
import org.spring.springboot.domain.User;

import java.util.List;

public interface AttentionsByUserAccountDao {
    @Select("SELECT * FROM attentions where user_account = #{userAccount}")
    @Results({
            @Result(property = "userAccount", column = "user_account"),
            @Result(property = "devId", column = "dev_id")
    })
    List<AttentionItem> findAttentionByUserAccount(@Param("userAccount") String userAccount);
}
