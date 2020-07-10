package com.mone.server.casemanagergenerator.config;

import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;

/**
 * @Description MySQL代码生成查询是否为空的列
 * @Classname MoneMySqlQuery
 * @auther motao
 * @create 2020-06-30 16:15
 */
public class MoneMySqlQuery extends MySqlQuery {

    @Override
    public String[] fieldCustom() {
        return new String[]{"null", "default"};
    }
}
