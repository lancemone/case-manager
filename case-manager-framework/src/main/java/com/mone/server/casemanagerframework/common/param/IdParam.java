package com.mone.server.casemanagerframework.common.param;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description
 * @Classname IdParam
 * @auther motao
 * @create 2020-07-10 18:14
 */

@Data
@ApiModel("ID参数")
public class IdParam implements Serializable {

    private static final long serialVersionUID = -5353973980674510450L;

    @NotNull(message = "ID不能为空")
    private Integer id;

    /**
     * 创建日期 - 现在时表示主动创建
     */
    @ApiModelProperty(value = "创建日期")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @Past(message = "创建时间必须是过去时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
