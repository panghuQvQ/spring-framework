package com.zhouyu;

import com.zhouyu.service.StudentService;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) throws Exception {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

		applicationContext.register();
//		UserService userService = (UserService) applicationContext.getBean("userService");
//		userService.test();

		System.out.println(applicationContext.getBean("teacherController"));
//		System.out.println(applicationContext.getBean("&person"));

//		applicationContext.close();
	}
}
