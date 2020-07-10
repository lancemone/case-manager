package com.mone.server.casemanagerstart.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.Date;

/**
 * <pre>
 * 系统用户表 查询结果对象
 * @Description :
 * @Classname : ${className}
 * @author : MoTao
 * @create 2020-07-10
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "UserQueryVo对象")
public class UserQueryVo implements Serializable {
private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户id")
    private Integer id;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("用户密码,默认值111111")
    private String password;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("手机号")
    private Long phone;

    @ApiModelProperty("盐值")
    private String salt;

    @ApiModelProperty("verify为username+password字段值小写MD5摘要值，用于校验密码更改后的token")
    private String verify;

    @ApiModelProperty("是否首次登录: 0:否;1:是")
    private Boolean firstLogin;

    @ApiModelProperty("账号启用状态: 0:禁用;1:启用")
    private Boolean enable;
}
