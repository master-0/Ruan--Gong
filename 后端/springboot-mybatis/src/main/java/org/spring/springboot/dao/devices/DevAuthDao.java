package org.spring.springboot.dao.devices;

import org.apache.ibatis.annotations.*;
import org.spring.springboot.domain.Device;

import java.util.List;

@Mapper
public interface DevAuthDao {
    @Select("SELECT * FROM devices where dev_auth >= #{devAuth}")
    // 返回 Map 结果集
    @Results({
            @Result(property = "devId", column = "dev_id"),
            @Result(property = "devName", column = "dev_name"),
            @Result(property = "devType", column = "dev_type"),
            @Result(property = "devPrise", column = "dev_prise"),
            @Result(property = "devDate", column = "dev_date"),
            @Result(property = "devPeriod", column = "dev_period"),
            @Result(property = "chargeAccount", column = "charge_account"),
            @Result(property = "managerAccount", column = "manager_account"),
            @Result(property = "devWorkStatus", column = "dev_work_status"),
            @Result(property = "devStatus", column = "dev_status"),
            @Result(property = "devAuth", column = "dev_auth"),
            @Result(property = "userAccount", column = "user_account")
    })
    List<Device> findDeviceByDevAuth(@Param("devAuth") int devAuth);
}
