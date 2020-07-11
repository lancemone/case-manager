package com.mone.server.casemanagerstart.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <pre>
 * 系统用户-组织表 查询结果对象
 * @Description :
 * @Classname : ${className}
 * @author : MoTao
 * @create 2020-07-11
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "UserTeamQueryVo对象")
public class UserTeamQueryVo implements Serializable {
private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键ID")
    private Integer id;

    @ApiModelProperty("用户ID")
    private Integer uid;

    @ApiModelProperty("组织ID")
    private Integer tid;

    @ApiModelProperty("是否为组织负责人: 1:是;0:否")
    private Boolean leader;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;
}
