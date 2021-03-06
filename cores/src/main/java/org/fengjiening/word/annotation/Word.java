package org.fengjiening.word.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by fengjiening on 2020/9/3.
 * @author fengjiening
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Word {

    String fileName() default "nuName";
    String fileType() default "doc";
    short  bgColor() default 0;
    String trmpFile() default "";
    String newPath() default "C://";

}

