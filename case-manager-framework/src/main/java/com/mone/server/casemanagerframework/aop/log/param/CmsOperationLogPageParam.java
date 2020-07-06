package com.mone.server.casemanagerframework.aop.log.param;

import com.mone.server.casemanagerframework.corn.pagination.BasePageOrderParam;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description 系统操作日志 分页参数对象
 * @Classname CmsOperationLogPageParam
 * @auther motao
 * @create 2020-07-06 15:19
 */

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "系统操作日志分页参数")
public class CmsOperationLogPageParam extends BasePageOrderParam {
}
