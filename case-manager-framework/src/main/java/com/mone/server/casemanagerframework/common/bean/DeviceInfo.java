package com.mone.server.casemanagerframework.common.bean;

import lombok.Data;

/**
 * @Description
 * @Classname DeviceInfo
 * @auther motao
 * @create 2020-07-06 10:40
 */

@Data
public class DeviceInfo {

    /**
     * 设备品牌
     */
    private String brand;

    /**
     * 设备型号
     */
    private String model;
}
