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
 * 系统用户-组织表
 *
 * @author : MoTao
 * @Description : UserTeam实体类
 * @create 2020-07-11
 */

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@TableName("cmu_user_team")
@ApiModel(value = "UserTeam对象")
public class UserTeam extends BaseEntity<UserTeam> {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id不能为空", groups = {Update.class})
    @ApiModelProperty("主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @NotNull(message = "用户ID不能为空")
    @ApiModelProperty("用户ID")
    private Integer uid;

    @NotNull(message = "组织ID不能为空")
    @ApiModelProperty("组织ID")
    private Integer tid;

    @ApiModelProperty("是否为组织负责人: 1:是;0:否")
    private Boolean leader;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

}
