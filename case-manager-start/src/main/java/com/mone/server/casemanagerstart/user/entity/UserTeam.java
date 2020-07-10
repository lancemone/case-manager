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
 * 系统用户-组织表
 * UserTeam实体类
 * @Description :
 * @Classname : ${className}
 * @author : MoTao
 * @create 2020-07-10
 */

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@TableName("cmu_user_team")
@ApiModel(value = "UserTeam对象")
public class UserTeam extends BaseEntity {
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

}
