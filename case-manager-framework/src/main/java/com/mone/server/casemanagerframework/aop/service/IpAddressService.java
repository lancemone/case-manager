package com.mone.server.casemanagerframework.aop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mone.server.casemanagerframework.aop.entity.IpAddressEntity;

/**
 * @Description
 * @Classname IpAddressService
 * @auther motao
 * @create 2020-07-06 14:52
 */
public interface IpAddressService extends IService<IpAddressEntity> {
    /**
     * 通过ip地址获取IP对象
     *
     * @param ip
     * @return
     */
    IpAddressEntity getByIp(String ip);

    /**
     * 通过ip地址获取区域
     *
     * @param ip
     * @return
     */
    String getAreaByIp(String ip);

    /**
     * 通过ip地址获取运营商
     *
     * @param ip
     * @return
     */
    String getOperatorByIp(String ip);
}
