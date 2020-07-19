package org.spring.springboot.dao.devices;

import org.apache.ibatis.annotations.*;
import org.spring.springboot.domain.Device;

import java.util.List;

@Mapper
public interface DevBuyDao {
    @Select("select dev_id from devices order by dev_id desc limit 1")
    @ResultType(Integer.class)
    Integer getPrimayKey();

    @Select("select dev_id from devicesTemp order by dev_id desc limit 1")
    @ResultType(Integer.class)
    Integer getTempPrimayKey();

    @Insert("insert into devices value(#{devId}, #{devName}, #{devType}, #{devPrise}, #{devDate}, #{devPeriod}, " +
            "#{chargeAccount}, null, #{managerAccount}, 1, 1, #{devAuth})")
    void buyDeviceByDevInfo(@Param("devId") int devId,
                            @Param("devName") String devName,
                            @Param("devType") String devType,
                            @Param("devPrise") float devPrise,
                            @Param("devDate") String devDate,
                            @Param("devPeriod") String devPeriod,
                            @Param("chargeAccount") String chargeAccount,
                            @Param("managerAccount") String managerAccount,
                            @Param("devAuth") int devAuth);

    @Insert("insert into devicesTemp value(#{devId}, #{devName}, #{devType}, #{devPrise}, #{devDate}, #{devPeriod}, " +
            "#{chargeAccount}, null, null, 1, 1, #{devAuth})")
    void buyDeviceTempByDevInfo(@Param("devId") int devId,
                            @Param("devName") String devName,
                            @Param("devType") String devType,
                            @Param("devPrise") float devPrise,
                            @Param("devDate") String devDate,
                            @Param("devPeriod") String devPeriod,
                            @Param("chargeAccount") String chargeAccount,
                            @Param("devAuth") int devAuth);

    @Select("SELECT * FROM devicesTemp where dev_id = #{devId}")
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
    List<Device> findTempDeviceBydevId(@Param("devId") int devId);

    @Delete("DELETE FROM devices where dev_id = #{devId}")
    void delDev(@Param("devId") int devId);

    @Delete("DELETE FROM devicesTemp where dev_id = #{devId}")
    void delDevTemp(@Param("devId") int devId);
}
