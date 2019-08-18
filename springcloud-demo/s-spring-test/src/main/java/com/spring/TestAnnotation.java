package com.spring;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.TYPE})
@Documented
public @interface TestAnnotation {

    String value() default "默认";
}
