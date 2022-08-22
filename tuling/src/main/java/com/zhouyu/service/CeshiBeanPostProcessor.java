package com.zhouyu.service;

import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @author wzy
 * @version 1.0.0
 * @ClassName CeshiBeanPostProcessor.java
 * @Description TODO
 * @createTime 2022年08月16日 22:41:00
 */
@Component
public class CeshiBeanPostProcessor implements InstantiationAwareBeanPostProcessor, MergedBeanDefinitionPostProcessor {
	@Override
	public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
		if (beanName.equals("teacherController")) {
			Person person = new Person();
			System.out.println("BeanDefinition===" + person);
			/**
			 * 给属性赋值，但类中必须有对应的set()方法
			 *
			 * 如果当前属性的有 @Autowired 注解，则先通过 @Autowired 赋值，然后是  set()赋值
 			 */

			beanDefinition.getPropertyValues().add("person", person);
		}
	}
}
