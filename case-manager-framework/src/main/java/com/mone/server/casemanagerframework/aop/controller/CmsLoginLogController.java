package com.mone.server.casemanagerframework.aop.controller;

import com.mone.server.casemanagerframework.aop.entity.CmsLoginLog;
import com.mone.server.casemanagerframework.aop.log.annotation.Module;
import com.mone.server.casemanagerframework.aop.log.annotation.OperationLog;
import com.mone.server.casemanagerframework.aop.log.enums.OperationLogType;
import com.mone.server.casemanagerframework.aop.log.param.CmsLoginLogPageParam;
import com.mone.server.casemanagerframework.aop.service.CmsLoginLogService;
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
 * @Description 系统登录日志 控制器
 * @Classname CmsLoginLogController
 * @auther motao
 * @create 2020-07-06 15:59
 */

@Slf4j
@RestController
@RequestMapping("/sys/log/login")
@Module("log")
@Api(value = "系统登录日志API", tags = {"系统登录日志"})
public class CmsLoginLogController {

    @Autowired
    private CmsLoginLogService loginLogService;

    /**
     * 系统登录日志分页列表
     */
    @PostMapping("/pageList")
//    @RequiresPermissions("sys:login:log:page")
    @OperationLog(name = "系统登录日志分页列表", type = OperationLogType.PAGE)
    @ApiOperation(value = "系统登录日志分页列表", response = CmsLoginLog.class)
    public ApiResult<Paging<CmsLoginLog>> getSysLoginLogPageList(@Validated @RequestBody CmsLoginLogPageParam cmsLoginLogPageParam) throws Exception {
        Paging<CmsLoginLog> paging = loginLogService.getCmsLoginLogPageList(cmsLoginLogPageParam);
        return ApiResult.ok(paging);
    }
}
