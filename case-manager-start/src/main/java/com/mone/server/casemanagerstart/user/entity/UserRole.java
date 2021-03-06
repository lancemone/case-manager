package com.mone.server.casemanagerstart.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mone.server.casemanagerframework.common.entity.BaseEntity;
import com.mone.server.casemanagerframework.corn.validator.groups.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 系统用户-角色表
 *
 * @author : MoTao
 * @Description : UserRole实体类
 * @create 2020-07-11
 */

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@TableName("cmu_user_role")
@ApiModel(value = "UserRole对象")
public class UserRole extends BaseEntity<UserRole> {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id不能为空", groups = {Update.class})
    @ApiModelProperty("主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @NotNull(message = "用户ID不能为空")
    @ApiModelProperty("用户ID")
    private Integer userId;

    @NotNull(message = "角色ID不能为空")
    @ApiModelProperty("角色ID")
    private Integer roleId;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

}
