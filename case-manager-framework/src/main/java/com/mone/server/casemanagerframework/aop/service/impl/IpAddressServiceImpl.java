package com.mone.server.casemanagerframework.aop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mone.server.casemanagerframework.aop.entity.IpAddressEntity;
import com.mone.server.casemanagerframework.aop.mapper.IpAddressMapper;
import com.mone.server.casemanagerframework.aop.service.IpAddressService;
import com.mone.server.config.constant.CommonConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Classname IpAddressServiceImpl
 * @auther motao
 * @create 2020-07-06 14:53
 */

@Slf4j
@Service
public class IpAddressServiceImpl extends ServiceImpl<IpAddressMapper, IpAddressEntity> implements IpAddressService {
    @Autowired
    private IpAddressMapper ipAddressMapper;

    @Override
    public IpAddressEntity getByIp(String ip) {
        if (StringUtils.isBlank(ip)) {
            return null;
        }
        if (CommonConstant.LOCALHOST_IP.equals(ip)) {
            return new IpAddressEntity().setArea(CommonConstant.LOCALHOST_IP_NAME);
        }
        if (CommonConstant.LAN_IP.equals(ip)) {
            return new IpAddressEntity().setArea(CommonConstant.LAN_IP_NAME);
        }
        return ipAddressMapper.getByIp(ip);
    }

    @Override
    public String getAreaByIp(String ip) {
        IpAddressEntity ipAddress = getByIp(ip);
        if (ipAddress != null) {
            return ipAddress.getArea();
        }
        return null;
    }

    @Override
    public String getOperatorByIp(String ip) {
        IpAddressEntity ipAddress = getByIp(ip);
        if (ipAddress != null) {
            return ipAddress.getOperator();
        }
        return null;
    }
}
