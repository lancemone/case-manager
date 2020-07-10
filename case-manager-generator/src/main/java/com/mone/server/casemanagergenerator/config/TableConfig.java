package com.mone.server.casemanagergenerator.config;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Description 生成的表信息配置
 * @Classname TableConfig
 * @auther motao
 * @create 2020-06-30 17:57
 */

@Data
@Accessors(chain = true)
public class TableConfig {

    /**
     * 生成的表名称
     */
    private String tableName;

    /**
     * 主键数据库列名称
     */
    private String pkIdName;
}
