package com.mone.server.casemanagerframework.corn.validator.constraints;

import com.mone.server.casemanagerframework.common.enums.BaseEnum;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * @Description 枚举类型注解
 * @Classname EnumType
 * @auther motao
 * @create 2020-07-06 14:19
 */

@Documented
@Constraint(validatedBy = {EnumTypeValidator.class})
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface EnumType {

    String message() default "请输入正确的类型值";

    Class<? extends BaseEnum> type();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
