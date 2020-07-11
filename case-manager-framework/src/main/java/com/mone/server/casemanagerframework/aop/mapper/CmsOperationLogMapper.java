package com.mone.server.casemanagerframework.aop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mone.server.casemanagerframework.aop.entity.CmsOperationLog;
import org.springframework.stereotype.Repository;

/**
 * @Description 系统操作日志 Mapper 接口
 * @Classname CmsOperationLogMapper
 * @auther motao
 * @create 2020-07-06 16:06
 */

@Repository
public interface CmsOperationLogMapper extends BaseMapper<CmsOperationLog> {
}
