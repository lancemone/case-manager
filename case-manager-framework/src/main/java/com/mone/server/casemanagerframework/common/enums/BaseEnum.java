package com.mone.server.casemanagerframework.common.enums;

/**
 * @Description 枚举类型父接口
 * @Classname BaseEnum
 * @auther motao
 * @create 2020-07-06 14:24
 */
public interface BaseEnum {

    /**
     * 获取枚举标识
     *
     * @return
     */
    Integer getCode();

    /**
     * 获取枚举描述
     *
     * @return
     */
    String getDesc();

    /**
     * 通过枚举类型和code值获取对应的枚举类型
     * @param enumType
     * @param code
     * @param <T>
     * @return
     */
    static <T extends BaseEnum> T valueOf(Class<? extends BaseEnum> enumType, Integer code) {
        if (enumType == null || code == null) {
            return null;
        }
        T[] enumConstants = (T[]) enumType.getEnumConstants();
        if (enumConstants == null) {
            return null;
        }
        for (T enumConstant : enumConstants) {
            int enumCode = enumConstant.getCode();
            if (code.equals(enumCode)) {
                return enumConstant;
            }
        }
        return null;
    }
}
