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

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * 系统组织表
 *
 * @author : MoTao
 * @Description : Team实体类
 * @create 2020-07-11
 */

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@TableName("cmu_team")
@ApiModel(value = "Team对象")
public class Team extends BaseEntity<Team> {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id不能为空", groups = {Update.class})
    @ApiModelProperty("组织id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @NotBlank(message = "组织名称不能为空")
    @ApiModelProperty("组织名称")
    private String name;

    @ApiModelProperty("父id")
    private int parentId;

    @NotBlank(message = "组织简介不能为空")
    @ApiModelProperty("组织简介")
    private String remarks;

    @NotBlank(message = "地址不能为空")
    @ApiModelProperty("地址")
    private String address;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

}
