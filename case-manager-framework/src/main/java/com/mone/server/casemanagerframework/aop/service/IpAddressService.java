package com.mone.server.casemanagerframework.aop.service;

import com.mone.server.casemanagerframework.aop.entity.IpAddressEntity;
import com.mone.server.casemanagerframework.common.service.BaseService;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Classname IpAddressService
 * @auther motao
 * @create 2020-07-06 14:52
 */

@Service
public interface IpAddressService extends BaseService<IpAddressEntity> {
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
