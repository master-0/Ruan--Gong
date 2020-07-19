package org.spring.springboot.dao.devices;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface DevRevertDao {
    @Update("update devices set user_account = null,  dev_status = 1 where dev_id = #{devId}")
    void revertDeviceByDevId(@Param("devId") int devId);
}
