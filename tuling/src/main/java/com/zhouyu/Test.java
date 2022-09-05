package com.zhouyu;

import com.zhouyu.postProcessor.CeshiBeanFactoryPostProcessor;
import com.zhouyu.service.StudentService;
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

//		UserService userService = (UserService) applicationContext.getBean("userService");
//		userService.test();

		System.out.println(applicationContext.getBean("teacherController"));
//		System.out.println(applicationContext.getBean("&person"));

//		applicationContext.close();
	}
}
