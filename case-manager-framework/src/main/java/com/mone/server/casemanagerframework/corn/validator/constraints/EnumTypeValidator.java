package com.mone.server.casemanagerframework.corn.validator.constraints;

import com.mone.server.casemanagerframework.common.enums.BaseEnum;
import com.mone.server.casemanagerframework.common.exception.BusinessException;
import com.mone.server.casemanagerframework.util.BaseEnumUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Description 自定义系统内的枚举验证注解实现类
 * @Classname EnumTypeValidator
 * @auther motao
 * @create 2020-07-06 14:20
 */
public class EnumTypeValidator implements ConstraintValidator<EnumType, Integer> {

    private Class<? extends BaseEnum> baseEnum;

    @Override
    public void initialize(EnumType constraintAnnotation) {
        baseEnum = constraintAnnotation.type();
        if (baseEnum == null) {
            throw new BusinessException("请传入枚举类型类");
        }
    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        if (integer == null) {
            return true;
        }
        return BaseEnumUtil.exists(baseEnum, integer);
    }
}
