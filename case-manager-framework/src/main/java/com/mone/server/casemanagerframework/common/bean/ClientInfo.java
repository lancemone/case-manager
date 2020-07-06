package com.mone.server.casemanagerframework.common.bean;

import lombok.Data;

/**
 * @Description 用户客户端信息对象
 * @Classname ClientInfo
 * @auther motao
 * @create 2020-07-06 10:35
 */

@Data
public class ClientInfo {

    /**
     * ip
     */
    private String ip;

    /**
     * ip对应的地址
     */
    private String addree;

    /**
     * 浏览器名称
     */
    private String browserName;

    /**
     * 浏览器版本
     */
    private String browserversion;

    /**
     * 系统名称
     */
    private String osName;

    /**
     * 是否是手机
     */
    private boolean mobile;

    /**
     * 移动端设备品牌
     */
    private String deviceBrand;

    /**
     * 移动端设备型号
     */
    private String deviceModel;
}
