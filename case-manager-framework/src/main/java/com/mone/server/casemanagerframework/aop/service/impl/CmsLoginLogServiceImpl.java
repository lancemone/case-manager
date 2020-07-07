package com.mone.server.casemanagerframework.aop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mone.server.casemanagerframework.aop.entity.CmsLoginLog;
import com.mone.server.casemanagerframework.aop.log.param.CmsLoginLogPageParam;
import com.mone.server.casemanagerframework.aop.mapper.CmsLoginLogMapper;
import com.mone.server.casemanagerframework.aop.service.CmsLoginLogService;
import com.mone.server.casemanagerframework.common.service.BaseServiceImpl;
import com.mone.server.casemanagerframework.corn.pagination.PageInfo;
import com.mone.server.casemanagerframework.corn.pagination.Paging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description
 * @Classname CmsLoginLogServiceImpl
 * @auther motao
 * @create 2020-07-06 15:39
 */

@Service
public class CmsLoginLogServiceImpl extends BaseServiceImpl<CmsLoginLogMapper, CmsLoginLog> implements CmsLoginLogService {


    @Autowired
    private CmsLoginLogMapper loginLogMapper;

    /**
     * 保存
     *
     * @param sysLoginLog
     * @return
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveCmsLoginLog(CmsLoginLog sysLoginLog) throws Exception {
        return super.save(sysLoginLog);
    }

    /**
     * 修改
     *
     * @param sysLoginLog
     * @return
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateCmsLoginLog(CmsLoginLog sysLoginLog) throws Exception {
        return super.updateById(sysLoginLog);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteCmsLoginLog(Long id) throws Exception {
        return super.removeById(id);
    }

    /**
     * 获取分页对象
     *
     * @param pageParam
     * @return
     * @throws Exception
     */
    @Override
    public Paging<CmsLoginLog> getCmsLoginLogPageList(CmsLoginLogPageParam pageParam) throws Exception {
        Page<CmsLoginLog> page = new PageInfo<>(pageParam, OrderItem.desc(getLambdaColumn(CmsLoginLog::getCreateTime)));
        LambdaQueryWrapper<CmsLoginLog> wrapper = new LambdaQueryWrapper<>();
        IPage<CmsLoginLog> iPage = loginLogMapper.selectPage(page, wrapper);
        return new Paging<CmsLoginLog>(iPage);
    }
}
