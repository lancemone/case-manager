package com.mone.server.casemanagerstart.user.controller;

import com.mone.server.casemanagerframework.aop.log.annotation.Module;
import com.mone.server.casemanagerframework.aop.log.annotation.OperationLog;
import com.mone.server.casemanagerframework.aop.log.enums.OperationLogType;
import com.mone.server.casemanagerframework.common.controller.BaseController;
import com.mone.server.casemanagerframework.common.reselt.ApiResult;
import com.mone.server.casemanagerframework.corn.pagination.Paging;
import com.mone.server.casemanagerframework.corn.validator.groups.Add;
import com.mone.server.casemanagerframework.corn.validator.groups.Update;
import com.mone.server.casemanagerstart.user.param.TeamPageParam;
import com.mone.server.casemanagerstart.user.service.TeamService;
import com.mone.server.casemanagerstart.user.vo.TeamQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 系统组织表 控制器
 * @Description :
 * @Classname : ${className}
 * @author : MoTao
 * @create 2020-07-11
 */
@Slf4j
@RestController
@RequestMapping("/team")
@Module("user")
@Api(value = "系统组织表API", tags = {"系统组织表"})
public class TeamController extends BaseController {

    @Autowired
    private TeamService teamService;

    /**
     * 添加系统组织表
     */
    @PostMapping("/add")
    @OperationLog(name = "添加系统组织表", type = OperationLogType.ADD)
    @ApiOperation(value = "添加系统组织表", response = ApiResult.class)
    public ApiResult addTeam(@Validated(Add.class) @RequestBody Team team) throws Exception {
        boolean flag = teamService.saveTeam(team);
        return ApiResult.result(flag);
    }

    /**
     * 修改系统组织表
     */
    @PostMapping("/update")
    @OperationLog(name = "修改系统组织表", type = OperationLogType.UPDATE)
    @ApiOperation(value = "修改系统组织表", response = ApiResult.class)
    public ApiResult updateTeam(@Validated(Update.class) @RequestBody Team team) throws Exception {
        boolean flag = teamService.updateTeam(team);
        return ApiResult.result(flag);
    }

    /**
     * 删除系统组织表
     */
    @PostMapping("/delete/{id}")
    @OperationLog(name = "删除系统组织表", type = OperationLogType.DELETE)
    @ApiOperation(value = "删除系统组织表", response = ApiResult.class)
    public ApiResult deleteTeam(@PathVariable("id") Long id) throws Exception {
        boolean flag = teamService.deleteTeam(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取系统组织表详情
     */
    @GetMapping("/info/{id}")
    @OperationLog(name = "系统组织表详情", type = OperationLogType.INFO)
    @ApiOperation(value = "系统组织表详情", response = TeamQueryVo.class)
    public ApiResult getTeam(@PathVariable("id") Integer id) throws Exception {
        TeamQueryVo teamQueryVo = teamService.getTeamById(id);
        return ApiResult.ok(teamQueryVo);
    }

    /**
     * 系统组织表分页列表
     */
    @PostMapping("/getPageList")
    @OperationLog(name = "系统组织表分页列表", type = OperationLogType.PAGE)
    @ApiOperation(value = "系统组织表分页列表", response = TeamQueryVo.class)
    public ApiResult getTeamPageList(@Validated @RequestBody TeamPageParam teamPageParam) throws Exception {

        Paging<TeamQueryVo> paging = teamService.getTeamPageList(teamPageParam);
        return ApiResult.ok(paging);
    }

}

