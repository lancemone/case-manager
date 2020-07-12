package com.mone.server.casemanagerstart.user.param;


import com.mone.server.casemanagerframework.corn.pagination.BasePageOrderParam;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <pre>
 * 通用 分页参数对象
 * @Description :
 * @Classname : ${className}
 * @author : MoTao
 * @create 2020-07-11
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "系统组织表分页参数")
public class CommonPageParam extends BasePageOrderParam {
    private static final long serialVersionUID = 1L;
}
