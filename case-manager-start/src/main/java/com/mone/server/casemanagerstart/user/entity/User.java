package com.mone.server.casemanagerstart.user.entity

import com.baomidou.mybatisplus.annotation.TableName
import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.Version
import com.baomidou.mybatisplus.annotation.TableId
import com.mone.server.casemanagerframework.common.entity.BaseEntity

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;
import com.mone.server.casemanagerframework.corn.validator.groups.Update;

/**
 * 系统用户表
 * User实体类
 * @Description :
 * @Classname : ${className}
 * @author : MoTao
 * @create 2020-07-10
 */

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@TableName("cmu_user")
@ApiModel(value = "User对象")
public class User extends BaseEntity {
private static final long serialVersionUID = 1L;

        @NotNull(message = "id不能为空", groups = {Update.class})
    @ApiModelProperty("用户id")
        @TableId(value = "id", type = IdType.AUTO)
                private Integer id;

        @NotBlank(message = "用户名不能为空")
    @ApiModelProperty("用户名")
            private String username;

        @ApiModelProperty("用户密码,默认值111111")
            private String password;

        @NotBlank(message = "邮箱不能为空")
    @ApiModelProperty("邮箱")
            private String email;

        @ApiModelProperty("手机号")
            private Long phone;

        @ApiModelProperty("盐值")
            private String salt;

        @NotBlank(message = "verify为username+password字段值小写MD5摘要值，用于校验密码更改后的token不能为空")
    @ApiModelProperty("verify为username+password字段值小写MD5摘要值，用于校验密码更改后的token")
            private String verify;

        @ApiModelProperty("是否首次登录: 0:否;1:是")
            private Boolean firstLogin;

        @ApiModelProperty("账号启用状态: 0:禁用;1:启用")
            private Boolean enable;

}
