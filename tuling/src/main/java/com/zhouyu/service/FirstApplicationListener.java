package com.zhouyu.service;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName FirstApplicationListener.java
 * @Description 事件监听器
 * AbstractApplicationContext.prepareBeanFactory()中，会往BeanFactory 中创建 ApplicationListenerDetector
 * @createTime 2022年09月01日 17:21:00
 */
@Component
public class FirstApplicationListener implements ApplicationListener {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println(event);
	}
}
