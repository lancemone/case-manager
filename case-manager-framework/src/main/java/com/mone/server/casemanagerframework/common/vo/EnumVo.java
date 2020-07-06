package com.mone.server.casemanagerframework.common.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Description 枚举类型VO
 * @Classname EnumVo
 * @auther motao
 * @create 2020-07-06 14:38
 */

@Data
@Accessors(chain = true)
public class EnumVo<T> {

    /**
     * 枚举code
     */
    private Integer code;

    /**
     * 枚举描述
     */
    private String desc;

    /**
     * 枚举类型
     */
    private T baseEnum;
}
