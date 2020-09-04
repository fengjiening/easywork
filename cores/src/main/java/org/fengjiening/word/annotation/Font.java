package org.fengjiening.word.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by fengjiening on 2020/9/3.
 * 设置文字样式
 * @author fengjiening
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})

public @interface Font {
    boolean center() default true;
    boolean  bold() default false;
    short fontSize() default 24;


}

