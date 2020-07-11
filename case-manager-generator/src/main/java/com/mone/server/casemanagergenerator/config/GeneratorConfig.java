package com.mone.server.casemanagergenerator.config;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * @Description 生成配置
 * @Classname GeneratorConfig
 * @auther motao
 * @create 2020-06-30 16:18
 */

@Data
@Accessors(chain = true)
public class GeneratorConfig {

    /**
     * 代码生成策略
     */
    @NestedConfigurationProperty
    public GeneratorStrategy generatorStrategy = GeneratorStrategy.ALL;
    /**
     * 是否生成实体类
     */
    private boolean generatorEntity = true;
    /**
     * 是否生成控制器
     */
    private boolean generatorController = false;
    /**
     * 是否生成service接口
     */
    private boolean generatorService = false;
    /**
     * 是否生成service实现类
     */
    private boolean generatorServiceImpl = false;
    /**
     * 是否生成Mapper
     */
    private boolean generatorMapper = false;
    /**
     * 是否生成Mapper XML
     */
    private boolean generatorMapperXml = false;
    /**
     * 是否生成查询参数
     */
    private boolean generatorPageParam = false;
    /**
     * 是否生成查询VO
     */
    private boolean generatorQueryVo = false;
    /**
     * 是否生成Shiro RequiresPermissions 注解
     */
    private boolean requiresPermissions = false;
    /**
     * 分页列表查询是否排序 true：有排序参数/false：无
     */
    private boolean pageListOrder = true;
    /**
     * 是否生成validation校验，true：生成/false：不生成
     */
    private boolean paramValidation = true;
    /**
     * 是否生成Swagger tags
     * true: @Api(value = "系统用户API",tags = {"系统用户"})
     * false: @Api("系统用户API")
     */
    private boolean swaggerTags = true;

    /**
     * 是否生成系统操作日志注解：@OperationLog
     */
    private boolean operationLog = true;
}
