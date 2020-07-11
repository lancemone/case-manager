package com.mone.server.casemanagerframework.aop.controller;

import com.mone.server.casemanagerframework.aop.entity.CmsOperationLog;
import com.mone.server.casemanagerframework.aop.log.param.CmsOperationLogPageParam;
import com.mone.server.casemanagerframework.aop.service.CmsOperationLogService;
import com.mone.server.casemanagerframework.common.reselt.ApiResult;
import com.mone.server.casemanagerframework.corn.pagination.Paging;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Classname CmsOperationLogController
 * @auther motao
 * @create 2020-07-06 16:18
 */

@Slf4j
@RestController
@RequestMapping("/sys/log/operation")
@Api(value = "系统操作日志API", tags = {"系统操作日志"})
public class CmsOperationLogController {

    @Autowired
    CmsOperationLogService operationLogService;

    /**
     * 系统操作日志分页列表
     */
    @PostMapping("/pageList")
//    @RequiresPermissions("sys:operation:log:page")
    @ApiOperation(value = "系统操作日志分页列表", response = CmsOperationLog.class)
    public ApiResult<Paging<CmsOperationLog>> getSysOperationLogPageList(@Validated @RequestBody CmsOperationLogPageParam sysOperationLogPageParam) throws Exception {
        Paging<CmsOperationLog> paging = operationLogService.getCmsOperationLogPageList(sysOperationLogPageParam);
        return ApiResult.ok(paging);
    }
}
