package com.mone.server.casemanagerstart.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.Date;

/**
 * <pre>
 * 系统用户-角色表 查询结果对象
 * @Description :
 * @Classname : ${className}
 * @author : MoTao
 * @create 2020-07-10
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "UserRoleQueryVo对象")
public class UserRoleQueryVo implements Serializable {
private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键ID")
    private Integer id;

    @ApiModelProperty("用户ID")
    private Integer userId;

    @ApiModelProperty("角色ID")
    private Integer roleId;

    @ApiModelProperty("角色名称")
    private String roleName;
}
