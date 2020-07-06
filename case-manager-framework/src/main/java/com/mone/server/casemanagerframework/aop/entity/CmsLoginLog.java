package com.mone.server.casemanagerframework.aop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.mone.server.casemanagerframework.common.entity.BaseEntity;
import com.mone.server.casemanagerframework.corn.validator.groups.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * @Description 系统登录日志
 * @Classname SysLoginLog
 * @auther motao
 * @create 2020-07-06 15:24
 */

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@ApiModel(value = "系统登录日志对象")
public class CmsLoginLog extends BaseEntity<CmsLoginLog> {

    @NotNull(message = "id不能为空", groups = {Update.class})
    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("请求ID")
    private String requestId;

    @ApiModelProperty("用户名称")
    private String username;

    @ApiModelProperty("IP")
    private String ip;

    @ApiModelProperty("区域")
    private String area;

    @ApiModelProperty("运营商")
    private String operator;

    @ApiModelProperty("tokenMd5值")
    private String token;

    @ApiModelProperty("1:登录，2：登出")
    private Integer type;

    @ApiModelProperty("是否成功 true:成功/false:失败")
    private Boolean success;

    @ApiModelProperty("响应码")
    private Integer code;

    @ApiModelProperty("失败消息记录")
    private String exceptionMessage;

    @ApiModelProperty("浏览器名称")
    private String userAgent;

    @ApiModelProperty("浏览器名称")
    private String browserName;

    @ApiModelProperty("浏览器版本")
    private String browserVersion;

    @ApiModelProperty("系统名称")
    private String osName;

    @ApiModelProperty("是否是手机,0:否,1:是")
    private Boolean mobile;

    @ApiModelProperty("移动端设备名称")
    private String deviceBrand;

    @ApiModelProperty("移动端设备型号")
    private String deviceModel;

    @ApiModelProperty("备注")
    private String remark;
}
