package com.mone.server.casemanagerstart.user.controller;

import com.mone.server.casemanagerframework.common.controller.BaseController;
import com.mone.server.casemanagerframework.common.reselt.ApiResult;
import com.mone.server.casemanagerframework.corn.pagination.Paging;
import com.mone.server.casemanagerframework.corn.validator.groups.Add;
import com.mone.server.casemanagerframework.corn.validator.groups.Update;
import com.mone.server.casemanagerstart.user.entity.UserRole;
import com.mone.server.casemanagerstart.user.param.UserRolePageParam;
import com.mone.server.casemanagerstart.user.service.UserRoleService;
import com.mone.server.casemanagerstart.user.vo.output.UserRoleQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 系统用户-角色表 控制器
 * @Description :
 * @Classname : ${className}
 * @author : MoTao
 * @create 2020-07-11
 */
@Slf4j
@RestController
@RequestMapping("/userRole")
@Api(value = "系统用户-角色表API", tags = {"系统用户-角色表"})
public class UserRoleController extends BaseController {

    @Autowired
    private UserRoleService userRoleService;

    /**
     * 添加系统用户-角色表
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加系统用户-角色表", response = ApiResult.class)
    public ApiResult addUserRole(@Validated(Add.class) @RequestBody UserRole userRole) throws Exception {
        boolean flag = userRoleService.saveUserRole(userRole);
        return ApiResult.result(flag);
    }

    /**
     * 修改系统用户-角色表
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改系统用户-角色表", response = ApiResult.class)
    public ApiResult updateUserRole(@Validated(Update.class) @RequestBody UserRole userRole) throws Exception {
        boolean flag = userRoleService.updateUserRole(userRole);
        return ApiResult.result(flag);
    }

    /**
     * 删除系统用户-角色表
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除系统用户-角色表", response = ApiResult.class)
    public ApiResult deleteUserRole(@PathVariable("id") Long id) throws Exception {
        boolean flag = userRoleService.deleteUserRole(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取系统用户-角色表详情
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "系统用户-角色表详情", response = UserRoleQueryVo.class)
    public ApiResult getUserRole(@PathVariable("id") Integer id) throws Exception {
        UserRoleQueryVo userRoleQueryVo = userRoleService.getUserRoleById(id);
        return ApiResult.ok(userRoleQueryVo);
    }

    /**
     * 系统用户-角色表分页列表
     */
    @PostMapping("/getPageList")
    @ApiOperation(value = "系统用户-角色表分页列表", response = UserRoleQueryVo.class)
    public ApiResult getUserRolePageList(@Validated @RequestBody UserRolePageParam userRolePageParam) throws Exception {

        Paging<UserRoleQueryVo> paging = userRoleService.getUserRolePageList(userRolePageParam);
        return ApiResult.ok(paging);
    }

}

