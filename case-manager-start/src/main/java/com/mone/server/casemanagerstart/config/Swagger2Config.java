package com.mone.server.casemanagerstart.config;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.mone.server.casemanagerframework.common.exception.ConfigException;
import com.mone.server.config.properties.SwaggerProperties;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * @Description RESTful 服务 API 管理框架 Swagger 配置初始化
 * @Classname Swagger2Config
 * @auther motao
 * @create 2020-07-07 10:57
 */

@Slf4j
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Autowired
    private SwaggerProperties swaggerProperties;

    /**
     * 扫描多包时，包路径的拆分符,分号
     */
    private static final String SPLIT_COMMA = ",";

    /**
     * Swagger忽略的参数类型
     */
    private Class<?>[] ignoredParameterTypes = new Class[]{
            ServletRequest.class,
            ServletResponse.class,
            HttpServletRequest.class,
            HttpServletResponse.class,
            HttpSession.class,
            ApiIgnore.class
    };

    @Bean
    public Docket createRestApi() {
        // 获取需要扫描的包
        String[] basePackages = getBasePackages();
        ApiSelectorBuilder apiSelectorBuilder = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select();
        // 如果扫描的包为空，则默认扫描类上有@Api注解的类
        if (ArrayUtils.isEmpty(basePackages)) {
            apiSelectorBuilder.apis(RequestHandlerSelectors.withClassAnnotation(Api.class));
        } else {
            // 扫描指定的包
            apiSelectorBuilder.apis(basePackage(basePackages));
        }
        return apiSelectorBuilder.paths(PathSelectors.any())
                .build()
                .enable(swaggerProperties.isEnable())
                .ignoredParameterTypes(ignoredParameterTypes);
    }

    /**
     * 获取apiInfo
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(swaggerProperties.getTitle())
                .description(swaggerProperties.getDescription())
                .contact(new Contact(swaggerProperties.getContactName(), swaggerProperties.getContactUrl(), swaggerProperties.getContactEmail()))
                .version(swaggerProperties.getVersion())
                .build();
    }

    /**
     * 获取扫描的包
     *
     * @return
     */
    public String[] getBasePackages() {
        log.debug("swaggerProperties = " + swaggerProperties);
        String basePackage = swaggerProperties.getBasePackage();
        if (StringUtils.isBlank(basePackage)) {
            throw new ConfigException("Swagger basePackage不能为空");
        }
        String[] basePackages = null;
        if (basePackage.contains(SPLIT_COMMA)) {
            basePackages = basePackage.split(SPLIT_COMMA);
        }
        log.info("swagger scan basePackages:" + Arrays.toString(basePackages));
        return basePackages;
    }

    public static Predicate<RequestHandler> basePackage(final String[] basePackages) {
        return input -> declaringClass(input).transform(handlerPackage(basePackages)).or(true);
    }

    private static Function<Class<?>, Boolean> handlerPackage(final String[] basePackages) {
        return input -> {
            // 循环判断匹配
            for (String strPackage : basePackages) {
                boolean isMatch = input.getPackage().getName().startsWith(strPackage);
                if (isMatch) {
                    return true;
                }
            }
            return false;
        };
    }

    @SuppressWarnings("deprecation")
    private static Optional<? extends Class<?>> declaringClass(RequestHandler input) {
        return Optional.fromNullable(input.declaringClass());
    }
}
