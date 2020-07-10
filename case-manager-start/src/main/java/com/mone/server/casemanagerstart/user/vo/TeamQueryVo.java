package com.mone.server.casemanagerstart.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.Date;

/**
 * <pre>
 * 系统组织表 查询结果对象
 * @Description :
 * @Classname : ${className}
 * @author : MoTao
 * @create 2020-07-10
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "TeamQueryVo对象")
public class TeamQueryVo implements Serializable {
private static final long serialVersionUID = 1L;

    @ApiModelProperty("组织id")
    private Integer id;

    @ApiModelProperty("组织名称")
    private String name;

    @ApiModelProperty("组织简介")
    private String remarks;

    @ApiModelProperty("地址")
    private String address;
}
