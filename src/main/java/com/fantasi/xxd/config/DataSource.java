package com.fantasi.xxd.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xxd
 * @date 2019/12/17 15:07
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface DataSource {
    DBTypeEnum value() default DBTypeEnum.db1Source;
}
