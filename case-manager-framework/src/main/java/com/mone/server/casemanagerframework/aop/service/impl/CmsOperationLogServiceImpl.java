package com.mone.server.casemanagerframework.aop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mone.server.casemanagerframework.aop.entity.CmsOperationLog;
import com.mone.server.casemanagerframework.aop.log.param.CmsOperationLogPageParam;
import com.mone.server.casemanagerframework.aop.mapper.CmsLoginLogMapper;
import com.mone.server.casemanagerframework.aop.mapper.CmsOperationLogMapper;
import com.mone.server.casemanagerframework.aop.service.CmsOperationLogService;
import com.mone.server.casemanagerframework.common.service.BaseServiceImpl;
import com.mone.server.casemanagerframework.corn.pagination.PageInfo;
import com.mone.server.casemanagerframework.corn.pagination.Paging;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description 系统操作日志 服务实现类
 * @Classname CmsOperationLogServiceImpl
 * @auther motao
 * @create 2020-07-06 16:10
 */

@Slf4j
@Service
public class CmsOperationLogServiceImpl extends BaseServiceImpl<CmsOperationLogMapper, CmsOperationLog> implements CmsOperationLogService {

    @Autowired
    private CmsOperationLogMapper cmsOperationLogMapper;

    /**
     * 保存
     *
     * @param cmsOperationLog
     * @return
     * @throws Exception
     */
    @Override
    public boolean saveCmsOperationLog(CmsOperationLog cmsOperationLog) throws Exception {
        return false;
    }

    /**
     * 修改
     *
     * @param cmsOperationLog
     * @return
     * @throws Exception
     */
    @Override
    public boolean updateCmsOperationLog(CmsOperationLog cmsOperationLog) throws Exception {
        return false;
    }

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public boolean deleteCmsOperationLog(Long id) throws Exception {
        return false;
    }

    /**
     * 获取分页对象
     *
     * @param cmsOperationLogPageParam@return
     * @throws Exception
     */
    @Override
    public Paging<CmsOperationLog> getCmsOperationLogPageList(CmsOperationLogPageParam cmsOperationLogPageParam) throws Exception {
        Page<CmsOperationLog> page = new PageInfo<>(cmsOperationLogPageParam, OrderItem.desc(getLambdaColumn(CmsOperationLog::getCreateTime)));
        LambdaQueryWrapper<CmsOperationLog> wrapper = new LambdaQueryWrapper<>();
        IPage<CmsOperationLog> iPage = cmsOperationLogMapper.selectPage(page, wrapper);
        return new Paging<CmsOperationLog>(iPage);
    }
}
