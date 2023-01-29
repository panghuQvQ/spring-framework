package com.zhouyu.boot;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName MyCondition.java
 * @Description TODO
 * @createTime 2022年12月12日 13:27:00
 */
public class MyCondition implements Condition {
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

		Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(ConditionalOnClass.class.getName());
		String className = (String) annotationAttributes.get("value");

		try {
			context.getClassLoader().loadClass(className);
			return true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
}
