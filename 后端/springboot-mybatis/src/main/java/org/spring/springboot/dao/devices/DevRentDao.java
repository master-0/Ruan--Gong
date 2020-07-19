package org.spring.springboot.dao.devices;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface DevRentDao {
    @Update("update devices set user_account = #{userAccount},  dev_status = 2 where dev_id = #{devId}")
    void lendDeviceByDevId(@Param("userAccount") String userAccount,
                           @Param("devId") int devId);

}