package org.spring.springboot.dao.devices;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface DevWorkStatusDao {
    @Update("update devices set dev_work_status = #{devWorkStatus} where dev_id = #{devId}")
    void updateDevWorkStatusByDevId(@Param("devId") int devId, @Param("devWorkStatus") int devWorkStatus);
}
