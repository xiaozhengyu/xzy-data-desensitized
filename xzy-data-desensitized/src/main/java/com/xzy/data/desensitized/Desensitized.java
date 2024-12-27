package com.xzy.data.desensitized;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据脱敏
 *
 * @author xzy.xiao
 * @implNote 仅对String类型的字段生效
 * @since 2024/12/27  9:23
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside
@JsonSerialize(using = DesensitizedSerializer.class)
public @interface Desensitized {

    /**
     * 脱敏类型
     */
    DesensitizedTypeEnum type() default DesensitizedTypeEnum.CUSTOM;

    /**
     * 脱敏开始位置
     */
    int startInclude() default 0;

    /**
     * 脱敏结束位置
     */
    int endExclude() default 0;
}
