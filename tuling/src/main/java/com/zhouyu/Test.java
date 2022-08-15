package com.zhouyu;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) throws Exception {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
//		UserService userService = (UserService) applicationContext.getBean("userService");
//		userService.test();

//		System.out.println(applicationContext.getBean("userService"));
		System.out.println(applicationContext.getBean("&person"));

//		applicationContext.close();
	}
}
