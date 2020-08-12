package com.mone.server.casemanagerstart.user.controller;
import com.mone.server.casemanagerframework.common.controller.BaseController;
import com.mone.server.casemanagerframework.common.reselt.ApiResult;
import com.mone.server.casemanagerframework.corn.pagination.Paging;
import com.mone.server.casemanagerframework.corn.validator.groups.Add;
import com.mone.server.casemanagerframework.corn.validator.groups.Update;
import com.mone.server.casemanagerstart.user.entity.Team;
import com.mone.server.casemanagerstart.user.param.TeamPageParam;
import com.mone.server.casemanagerstart.user.service.TeamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
@Api(value = "系统组织表API", tags = {"系统组织表"})
public class TeamController extends BaseController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    /**
     * 添加系统组织表
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加系统组织表", response = ApiResult.class)
    public ApiResult<Boolean> addTeam(@Validated(Add.class) @RequestBody Team team) throws Exception {
        boolean flag = teamService.saveTeam(team);
        return ApiResult.result(flag);
    }

    /**
     * 修改系统组织表
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改系统组织表", response = ApiResult.class)
    public ApiResult<Boolean> updateTeam(@Validated(Update.class) @RequestBody Team team) throws Exception {
        boolean flag = teamService.updateTeam(team);
        return ApiResult.result(flag);
    }

    /**
     * 删除系统组织表
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除系统组织表", response = ApiResult.class)
    public ApiResult<Boolean> deleteTeam(@PathVariable("id") Long id) throws Exception {
        boolean flag = teamService.deleteTeam(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取系统组织表详情
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "系统组织表详情", response = Team.class)
    public ApiResult<Team> getTeam(@PathVariable("id") Integer id) throws Exception {
        Team team = teamService.getTeamInfoById(id);
        return ApiResult.ok(team);
    }

    /**
     * @param parentId 部门父id
     * @return
     * @throws Exception
     */
    @GetMapping("/list/{parentId}")
    public ApiResult<List<Team>> getTeamsByParentId(@PathVariable("parentId") int parentId) throws Exception {
        List<Team> teams = teamService.getTeamsByParentId(parentId);
        return ApiResult.ok(teams);
    }

    /**
     * 系统组织表分页列表
     */
    @PostMapping("/getPageList")
    @ApiOperation(value = "系统组织表分页列表", response = TeamQueryVo.class)
    public ApiResult<Paging<TeamQueryVo>> getTeamPageList(@Validated @RequestBody TeamPageParam teamPageParam) throws Exception {

        Paging<TeamQueryVo> paging = teamService.getTeamPageList(teamPageParam);
        return ApiResult.ok(paging);
    }

}

