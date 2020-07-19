package org.spring.springboot.dao.logs;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface LogUpdateDao {
    @Update("update logs set token_status = #{logStatus} where log_id = #{logId}")
    void updateByLogId(@Param("logId") int logId, @Param("logStatus") int logStatus);
}
