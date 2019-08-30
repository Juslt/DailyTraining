package com.example.juslt.retorfitdemo.annotation;

import java.lang.annotation.*;

/**
 * Created by Juslt on 2019/7/29
 */

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AnnotationTest {
    int a() default -1;
    String show() default "i am annotation";
}
