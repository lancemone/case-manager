package com.mone.server.casemanagerstart.user.controller;

import com.mone.server.casemanagerframework.common.controller.BaseController;
import com.mone.server.casemanagerframework.common.reselt.ApiResult;
import com.mone.server.casemanagerframework.corn.pagination.Paging;
import com.mone.server.casemanagerframework.corn.validator.groups.Add;
import com.mone.server.casemanagerframework.corn.validator.groups.Update;
import com.mone.server.casemanagerstart.user.entity.User;
import com.mone.server.casemanagerstart.user.param.UserPageParam;
import com.mone.server.casemanagerstart.user.service.UserService;
import com.mone.server.casemanagerstart.user.vo.output.UserQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 系统用户表 控制器
 * @Description :
 * @Classname : ${className}
 * @author : MoTao
 * @create 2020-07-11
 */
@Slf4j
@RestController
@RequestMapping("/user")
@Api(value = "系统用户表API", tags = {"系统用户表"})
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * 添加系统用户表
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加系统用户表", response = ApiResult.class)
    public ApiResult addUser(@Validated(Add.class) @RequestBody User user) throws Exception {
        boolean flag = userService.saveUser(user);
        return ApiResult.result(flag);
    }

    /**
     * 修改系统用户表
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改系统用户表", response = ApiResult.class)
    public ApiResult updateUser(@Validated(Update.class) @RequestBody User user) throws Exception {
        boolean flag = userService.updateUser(user);
        return ApiResult.result(flag);
    }

    /**
     * 删除系统用户表
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除系统用户表", response = ApiResult.class)
    public ApiResult deleteUser(@PathVariable("id") Long id) throws Exception {
        boolean flag = userService.deleteUser(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取系统用户表详情
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "系统用户表详情", response = UserQueryVo.class)
    public ApiResult getUser(@PathVariable("id") Integer id) throws Exception {
        UserQueryVo userQueryVo = userService.getUserById(id);
        return ApiResult.ok(userQueryVo);
    }

    /**
     * 系统用户表分页列表
     */
    @PostMapping("/getPageList")
    @ApiOperation(value = "系统用户表分页列表", response = UserQueryVo.class)
    public ApiResult getUserPageList(@Validated @RequestBody UserPageParam userPageParam) throws Exception {

        Paging<UserQueryVo> paging = userService.getUserPageList(userPageParam);
        return ApiResult.ok(paging);
    }

}

