package com.mone.server.casemanagerstart.user.controller;

import com.mone.server.casemanagerframework.aop.log.annotation.Module;
import com.mone.server.casemanagerframework.aop.log.annotation.OperationLog;
import com.mone.server.casemanagerframework.aop.log.enums.OperationLogType;
import com.mone.server.casemanagerframework.common.controller.BaseController;
import com.mone.server.casemanagerframework.common.reselt.ApiResult;
import com.mone.server.casemanagerframework.corn.pagination.Paging;
import com.mone.server.casemanagerframework.corn.validator.groups.Add;
import com.mone.server.casemanagerframework.corn.validator.groups.Update;
import com.mone.server.casemanagerstart.user.param.UserTeamPageParam;
import com.mone.server.casemanagerstart.user.service.UserTeamService;
import com.mone.server.casemanagerstart.user.vo.UserTeamQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 系统用户-组织表 控制器
 * @Description :
 * @Classname : ${className}
 * @author : MoTao
 * @create 2020-07-11
 */
@Slf4j
@RestController
@RequestMapping("/userTeam")
@Module("user")
@Api(value = "系统用户-组织表API", tags = {"系统用户-组织表"})
public class UserTeamController extends BaseController {

    @Autowired
    private UserTeamService userTeamService;

    /**
     * 添加系统用户-组织表
     */
    @PostMapping("/add")
    @OperationLog(name = "添加系统用户-组织表", type = OperationLogType.ADD)
    @ApiOperation(value = "添加系统用户-组织表", response = ApiResult.class)
    public ApiResult addUserTeam(@Validated(Add.class) @RequestBody UserTeam userTeam) throws Exception {
        boolean flag = userTeamService.saveUserTeam(userTeam);
        return ApiResult.result(flag);
    }

    /**
     * 修改系统用户-组织表
     */
    @PostMapping("/update")
    @OperationLog(name = "修改系统用户-组织表", type = OperationLogType.UPDATE)
    @ApiOperation(value = "修改系统用户-组织表", response = ApiResult.class)
    public ApiResult updateUserTeam(@Validated(Update.class) @RequestBody UserTeam userTeam) throws Exception {
        boolean flag = userTeamService.updateUserTeam(userTeam);
        return ApiResult.result(flag);
    }

    /**
     * 删除系统用户-组织表
     */
    @PostMapping("/delete/{id}")
    @OperationLog(name = "删除系统用户-组织表", type = OperationLogType.DELETE)
    @ApiOperation(value = "删除系统用户-组织表", response = ApiResult.class)
    public ApiResult deleteUserTeam(@PathVariable("id") Long id) throws Exception {
        boolean flag = userTeamService.deleteUserTeam(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取系统用户-组织表详情
     */
    @GetMapping("/info/{id}")
    @OperationLog(name = "系统用户-组织表详情", type = OperationLogType.INFO)
    @ApiOperation(value = "系统用户-组织表详情", response = UserTeamQueryVo.class)
    public ApiResult getUserTeam(@PathVariable("id") Integer id) throws Exception {
        UserTeamQueryVo userTeamQueryVo = userTeamService.getUserTeamById(id);
        return ApiResult.ok(userTeamQueryVo);
    }

    /**
     * 系统用户-组织表分页列表
     */
    @PostMapping("/getPageList")
    @OperationLog(name = "系统用户-组织表分页列表", type = OperationLogType.PAGE)
    @ApiOperation(value = "系统用户-组织表分页列表", response = UserTeamQueryVo.class)
    public ApiResult getUserTeamPageList(@Validated @RequestBody UserTeamPageParam userTeamPageParam) throws Exception {

        Paging<UserTeamQueryVo> paging = userTeamService.getUserTeamPageList(userTeamPageParam);
        return ApiResult.ok(paging);
    }

}

