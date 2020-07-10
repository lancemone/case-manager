package com.mone.server.casemanagerframework.common.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description
 * @Classname BaseEntity
 * @auther motao
 * @create 2020-06-23 11:18
 */

@Data
public abstract class BaseEntity<T extends Model<?>> extends Model<T> implements Serializable {
    private static final long serialVersionUID = -7176390653391227433L;
}
