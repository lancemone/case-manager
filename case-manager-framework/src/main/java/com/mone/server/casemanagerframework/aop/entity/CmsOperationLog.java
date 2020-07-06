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
 * @Description 系统操作日志
 * @Classname CmsOperationLog
 * @auther motao
 * @create 2020-07-06 15:31
 */

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "系统操作日志对象")
public class CmsOperationLog extends BaseEntity<CmsOperationLog> {

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    @NotNull(message = "id不能为空", groups = {Update.class})
    private Long id;

    @ApiModelProperty("请求ID")
    private String requestId;

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("用户名称")
    private String userName;

    @ApiModelProperty("日志名称")
    private String name;

    @ApiModelProperty("IP")
    private String ip;

    @ApiModelProperty("区域")
    private String area;

    @ApiModelProperty("运营商")
    private String operator;

    @ApiModelProperty("全路径")
    private String path;

    @ApiModelProperty("模块名称")
    private String module;

    @ApiModelProperty("类名")
    private String className;

    @ApiModelProperty("方法名称")
    private String methodName;

    @ApiModelProperty("请求方式，GET/POST")
    private String requestMethod;

    @ApiModelProperty("内容类型")
    private String contentType;

    @ApiModelProperty("是否是JSON请求映射参数")
    private Boolean requestBody;

    @ApiModelProperty("请求参数")
    private String param;

    @ApiModelProperty("tokenMd5值")
    private String token;

    @ApiModelProperty("0:其它,1:新增,2:修改,3:删除,4:详情查询,5:所有列表,6:分页列表,7:其它查询,8:上传文件")
    private Integer type;

    @ApiModelProperty("0:失败,1:成功")
    private Boolean success;

    @ApiModelProperty("响应结果状态码")
    private Integer code;

    @ApiModelProperty("响应结果消息")
    private String message;

    @ApiModelProperty("异常类名称")
    private String exceptionName;

    @ApiModelProperty("异常信息")
    private String exceptionMessage;

    @ApiModelProperty("浏览器名称")
    private String browserName;

    @ApiModelProperty("浏览器版本")
    private String browserVersion;

    @ApiModelProperty("浏览器引擎名称")
    private String engineName;

    @ApiModelProperty("浏览器引擎版本")
    private String engineVersion;

    @ApiModelProperty("系统名称")
    private String osName;

    @ApiModelProperty("平台名称")
    private String platformName;

    @ApiModelProperty("是否是手机,0:否,1:是")
    private Boolean mobile;

    @ApiModelProperty("移动端设备名称")
    private String deviceName;

    @ApiModelProperty("移动端设备型号")
    private String deviceModel;

    @ApiModelProperty("备注")
    private String remark;
}
