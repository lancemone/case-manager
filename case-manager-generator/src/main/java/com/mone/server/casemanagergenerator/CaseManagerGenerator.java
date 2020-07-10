package com.mone.server.casemanagergenerator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.mone.server.casemanagergenerator.config.GeneratorStrategy;
import com.mone.server.casemanagergenerator.constants.GeneratorConstant;
import com.mone.server.casemanagergenerator.properties.GeneratorProperties;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * @Description 代码生成器入口类
 * @Classname CaseManagerGenerator
 * @auther motao
 * @create 2020-06-30 18:15
 */

@Component
public class CaseManagerGenerator {

    /**
     * 生成代码
     * @param args
     */

    public static void main(String[] args) {
        GeneratorProperties generatorProperties = new GeneratorProperties();
        // 设置基本信息
        generatorProperties
                .setMavenModuleName("case-manager-start")
                .setParentPackage("com.mone.server.casemanagerstart")
                .setModuleName("user")
                .setAuthor("MoTao")
                .setFileOverride(false);

        // 设置表信息
        generatorProperties.addTable("cmu_user","id");
        generatorProperties.addTable("cmu_user_role", "id");
        generatorProperties.addTable("cmu_team", "id");
        generatorProperties.addTable("cmu_user_team", "id");
        // 设置表前缀
        generatorProperties.setTablePrefix(Collections.singletonList("cmu_"));

        // 数据源配置
        generatorProperties.getDataSourceConfig()
                .setDbType(DbType.MYSQL)
                .setUsername("root")
                .setPassword("sJ8UPhQ_LA94tUm")
                .setDriverName("com.mysql.jdbc.Driver")
                .setUrl("jdbc:mysql://cdb-4x9gogum.bj.tencentcdb.com:10247/case_manager?useUnicode=true&characterEncoding=UTF-8&useSSL=false");

        // 生成配置
//        generatorProperties.getGeneratorConfig()
//                .setGeneratorStrategy(GeneratorStrategy.SINGLE)
//                .setGeneratorEntity(true)
//                .setGeneratorController(true)
//                .setGeneratorService(true)
//                .setGeneratorServiceImpl(true)
//                .setGeneratorMapper(true)
//                .setGeneratorMapperXml(true)
//                .setGeneratorPageParam(true)
//                .setGeneratorQueryVo(true)
//                .setRequiresPermissions(false)
//                .setPageListOrder(true)
//                .setParamValidation(true)
//                .setSwaggerTags(true)
//                .setOperationLog(false);

        // 全局配置
        generatorProperties.getMybatisPlusGeneratorConfig().getGlobalConfig()
                .setOpen(true)
                .setSwagger2(true)
                .setIdType(IdType.AUTO)
                .setDateType(DateType.ONLY_DATE);

        // 策略配置
        generatorProperties.getMybatisPlusGeneratorConfig().getStrategyConfig()
                .setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setEntityLombokModel(true)
                .setRestControllerStyle(true)
                .setControllerMappingHyphenStyle(true)
                .setVersionFieldName(GeneratorConstant.VERSION)
                .setLogicDeleteFieldName(GeneratorConstant.DELETED);

        // 生成代码
        CodeGenerator codeGenerator = new CodeGenerator();
        codeGenerator.generator(generatorProperties);

    }
}
