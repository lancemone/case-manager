package com.mone.server.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description JWT属性配置
 * @Classname JwtProperties
 * @auther motao
 * @create 2020-07-03 18:14
 */

@Data
@Component
@ConfigurationProperties(prefix = "case-manager.jwt")
public class JwtProperties {

    /**
     * token请求头名称,默认名称为：token，可自定义
     */
    private String header;

    /**
     * token填充
     */
    private String tokenStart;

    /**
     * 密码
     */
    private String secret;

    /**
     * 签发人
     */
    private String issuer;

    /**
     * 主题
     */
    private String subject;

    /**
     * 签发的目标
     */
    private String audience;

    /**
     * token失效时间,默认1小时，60*60=3600
     */
    private Long expireSecond;

    /**
     * 是否刷新token，默认为true
     */
    private boolean refreshToken = true;

    /**
     * 刷新token倒计时，默认10分钟，10*60=600
     */
    private Integer refreshTokenCountdown;

    /**
     * redis校验jwt token是否存在
     */
    private boolean redisCheck;

    /**
     * 单用户登录，一个用户只能又一个有效的token
     */
    private boolean singleLogin;

    /**
     * 是否进行盐值校验
     */
    private boolean saltCheck;
}
