package com.zhouyu.service;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * 事件监听器,实现一：
 * AbstractApplicationContext.prepareBeanFactory()中，会往BeanFactory 中创建 ApplicationListenerDetector（它是一个BeanPostProcessor）
 * 调用 ApplicationListenerDetector.postProcessAfterInitialization() 来判断这个Bean是否是事件监听器，如果是，则添加至applicationContext 中
 */
@Component
public class FirstApplicationListener implements ApplicationListener {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		PayloadApplicationEvent applicationEvent = (PayloadApplicationEvent) event;
		System.out.println(applicationEvent.getPayload());
	}
}
