package com.mone.server.casemanagerframework.aop.service;

import com.mone.server.casemanagerframework.aop.entity.CmsLoginLog;
import com.mone.server.casemanagerframework.aop.log.param.CmsLoginLogPageParam;
import com.mone.server.casemanagerframework.common.service.BaseService;
import com.mone.server.casemanagerframework.corn.pagination.Paging;

/**
 * @Description 系统登录日志 服务类
 * @Classname SysLoginLogService
 * @auther motao
 * @create 2020-07-06 15:34
 */

public interface CmsLoginLogService extends BaseService<CmsLoginLog> {

    /**
     * 保存
     *
     * @param sysLoginLog
     * @return
     * @throws Exception
     */
    boolean saveCmsLoginLog(CmsLoginLog sysLoginLog) throws Exception;

    /**
     * 修改
     *
     * @param sysLoginLog
     * @return
     * @throws Exception
     */
    boolean updateCmsLoginLog(CmsLoginLog sysLoginLog) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteCmsLoginLog(Long id) throws Exception;

    /**
     * 获取分页对象
     * @param pageParam
     * @return
     * @throws Exception
     */
    Paging<CmsLoginLog> getCmsLoginLogPageList(CmsLoginLogPageParam pageParam) throws Exception;
}
