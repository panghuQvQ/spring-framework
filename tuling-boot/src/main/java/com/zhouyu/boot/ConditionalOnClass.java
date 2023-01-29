package com.zhouyu.boot;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ConditionalOnClass.java
 * @Description TODO
 * @createTime 2022年12月12日 14:59:00
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Conditional(MyCondition.class)
public @interface ConditionalOnClass {

	String value();
}
