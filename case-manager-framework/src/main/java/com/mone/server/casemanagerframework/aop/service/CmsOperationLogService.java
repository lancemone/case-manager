package com.mone.server.casemanagerframework.aop.service;

import com.mone.server.casemanagerframework.aop.entity.CmsOperationLog;
import com.mone.server.casemanagerframework.aop.log.param.CmsOperationLogPageParam;
import com.mone.server.casemanagerframework.common.service.BaseService;
import com.mone.server.casemanagerframework.corn.pagination.Paging;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Classname CmsOperationLogService
 * @auther motao
 * @create 2020-07-06 16:07
 */


public interface CmsOperationLogService extends BaseService<CmsOperationLog> {

    /**
     * 保存
     *
     * @param cmsOperationLog
     * @return
     * @throws Exception
     */
    boolean saveCmsOperationLog(CmsOperationLog cmsOperationLog) throws Exception;

    /**
     * 修改
     *
     * @param cmsOperationLog
     * @return
     * @throws Exception
     */
    boolean updateCmsOperationLog(CmsOperationLog cmsOperationLog) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteCmsOperationLog(Long id) throws Exception;


    /**
     * 获取分页对象
     *
     * @param
     * @return
     * @throws Exception
     */
    Paging<CmsOperationLog> getCmsOperationLogPageList(CmsOperationLogPageParam cmsOperationLogPageParam) throws Exception;

}
