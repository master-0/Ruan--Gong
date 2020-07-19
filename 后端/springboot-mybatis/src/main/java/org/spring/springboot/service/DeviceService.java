package org.spring.springboot.service;

import org.spring.springboot.domain.Device;

import java.util.List;

public interface DeviceService extends Service {

    List<Device> findDeviceByDevId(Integer devId) throws Exception;

    List<Device> findDeviceByManagerAccount(String managerAccount);

    List<Device> findDeviceByDevAuth(Integer devAuth);

    List<Device> findDeviceByUserAccount(String userAccount) throws Exception;

    List<Device> lendDeviceByDevId(String userAccount, Integer devId) throws Exception;

    List<Device> findDeviceByDevUserAccount(String userAccount);

    List<Device> revertDeviceByDevId(String userAccount, Integer devId) throws Exception;

    List<Device> buyDeviceByDevInfo(String devName, String devType, Float devPrise, String devPeriod, String chargeAccount,
                                    String managerAccount, Integer devAuth, Integer number) throws Exception;
    List<Device> buyDeviceTempByDevInfo(String devName, String devType, Float devPrise, String devPeriod, String chargeAccount,
                                        Integer devAuth, Integer number) throws Exception;

    List<Device> findTemp(Integer devId) throws Exception;
}
