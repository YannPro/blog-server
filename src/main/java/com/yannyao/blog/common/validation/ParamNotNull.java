package com.yannyao.blog.common.validation;


import com.yannyao.blog.common.exception.BaseErrors;
import com.yannyao.blog.common.exception.BusinessException;
import com.yannyao.blog.common.util.ObjectUtil;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @Author: yjy
 * @Date: 2018/9/28 19:12
 * @Desciption: 验证参数是否为空
 */
@Target( {  ElementType.FIELD,  ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ParamNotNull.NotNullValidator.class)
@Documented
public @interface ParamNotNull {
    String value() default "缺少参数或参数为空";
    String message() default "";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    class NotNullValidator implements ConstraintValidator<ParamNotNull, Object> {
        private String value;

        @Override
        public void initialize(ParamNotNull constraintAnnotation) {
            value = constraintAnnotation.value() + "不能为空";
        }

        @Override
        public boolean isValid(Object object, ConstraintValidatorContext constraintContext) {
            if (ObjectUtil.isNotEmpty(object)) {
                return true;
            } else {
                throw new BusinessException(value, BaseErrors.REQUEST_PARAM_ERROR);
            }
        }
    }

}
