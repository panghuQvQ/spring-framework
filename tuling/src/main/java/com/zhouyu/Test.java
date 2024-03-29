package com.zhouyu;

import com.zhouyu.postProcessor.CeshiBeanFactoryPostProcessor;
import com.zhouyu.service.AService;
import com.zhouyu.service.StudentService;
import com.zhouyu.service.User;
import com.zhouyu.service.UserService;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class Test {

	public static void main(String[] args) throws Exception {

//		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
//		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
		applicationContext.register(AppConfig.class);
//		applicationContext.setClassLoader();
//		applicationContext.getBeanFactory().registerSingleton("111",StudentService.class); // 手动注册，单例Bean
//		applicationContext.addBeanFactoryPostProcessor(new CeshiBeanFactoryPostProcessor()); // 可以使用此方法，添加 BeanFactory后置处理器
		applicationContext.refresh();

		applicationContext.publishEvent("123"); // 如果没设置，则用默认的事件发布器：SimpleApplicationEventMulticaster，发布事件

//		AService AService = (AService) applicationContext.getBean("AService");
//		AService.test();

		UserService userService = (UserService) applicationContext.getBean("userService");
		userService.a();

		User user = (User) applicationContext.getBean("user");
//		String test = user.test();
//		System.out.println(test);

//		System.out.println(applicationContext.getBean("teacherController"));
		System.out.println(applicationContext.getBean("&person"));
		System.out.println(applicationContext.getBean("person"));

//		applicationContext.close();
	}
}
