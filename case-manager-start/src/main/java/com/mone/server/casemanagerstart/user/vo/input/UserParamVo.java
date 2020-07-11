package com.mone.server.casemanagerstart.user.vo.input;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * @Description 添加、修改用户信息参数
 * @Classname UserParamVo
 * @auther taomo
 * @create 2020/7/11 11:36 上午
 */

@Data
@Accessors(chain = true)
@ApiModel(value = "用户信息输入参数对象")
public class UserParamVo {

    @ApiModelProperty("用户id")
    private Integer id;

    @ApiModelProperty("用户名")
    @NotNull(message = "用户名不能为空")
    private String username;

    @ApiModelProperty("用户密码,默认值111111")
    private String password;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("手机号")
    private Long phone;

    @ApiModelProperty("账号启用状态: 0:禁用;1:启用")
    private Boolean enable;
}
