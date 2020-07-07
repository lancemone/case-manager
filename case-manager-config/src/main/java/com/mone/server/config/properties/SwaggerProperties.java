package com.mone.server.config.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Classname SwaggerProperties
 * @auther motao
 * @create 2020-07-07 10:58
 */

@Data
@ConfigurationProperties(prefix = "case-manager.swagger")
@Component
public class SwaggerProperties {

    /**
     * 是否启用Swagger
     */
    private boolean enable;

    /**
     * 扫描的基本包
     */
    @Value("${case-manager.swagger.base.package}")
    private String basePackage;

    /**
     * 联系人邮箱
     */
    @Value("${case-manager.swagger.contact.email}")
    private String contactEmail;

    /**
     * 联系人名称
     */
    @Value("${case-manager.swagger.contact.name}")
    private String contactName;

    /**
     * 联系人网址
     */
    @Value("${case-manager.swagger.contact.url}")
    private String contactUrl;

    /**
     * 描述
     */
    private String description;

    /**
     * 标题
     */
    private String title;

    /**
     * 版本
     */
    private String version;
}
