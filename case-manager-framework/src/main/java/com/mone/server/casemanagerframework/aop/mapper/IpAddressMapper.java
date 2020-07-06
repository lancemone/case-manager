package com.mone.server.casemanagerframework.aop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mone.server.casemanagerframework.aop.entity.IpAddressEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Description IP地址 Mapper 接口
 * @Classname IpAddressMapper
 * @auther motao
 * @create 2020-07-06 14:49
 */

@Repository
public interface IpAddressMapper extends BaseMapper<IpAddressEntity> {

    /**
     * 通过ip地址获取IP对象
     *
     * @param ip
     * @return
     */
    IpAddressEntity getByIp(@Param("ip") String ip);
}
