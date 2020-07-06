package com.mone.server.casemanagerframework.common.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Description
 * @Classname BaseEntity
 * @auther motao
 * @create 2020-06-23 11:18
 */

@Getter
@Setter
public abstract class BaseEntity<T extends Model<?>> extends BaseAddEntity<T>{

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
