package org.spring.springboot.dao.logs;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

public interface LogsAddBasicRecordDao {
    @Select("select log_id from logs order by log_id desc limit 1")
    @ResultType(Integer.class)
    Integer getPrimayKey();

    @Insert("insert into logs(dev_id, dev_status, dev_work_status, token_id, token_status, sender_account, receiver_account, change_time, auth) value(#{devId}, #{devStatus}, #{devWorkStatus}, #{tokenId}, #{tokenStatus}, #{senderAccount}, #{receiverAccount}, #{changeTime}, #{auth})")
    void logsAddBasicRecord(@Param("devId") int devId,
                            @Param("devStatus") int devStatus,
                            @Param("devWorkStatus") int devWorkStatus,
                            @Param("tokenId") int tokenId,
                            @Param("tokenStatus") int tokenStatus,
                            @Param("senderAccount") String senderAccount,
                            @Param("receiverAccount") String receiverAccount,
                            @Param("changeTime") String changeTime,
                            @Param("auth") int auth
    );
}
