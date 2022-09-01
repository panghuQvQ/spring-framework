package com.zhouyu.service;

import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName SpringLifecycle.java
 * @Description 用于监听，Spring 生命周期，Spring容器有没有创建好
 * @createTime 2022年09月01日 16:17:00
 */
@Component
public class SpringLifecycle implements SmartLifecycle {

	private boolean isRunning;

	@Override
	public void start() { // finishRefresh() 方法中会调用
		System.out.println("Spring启动完成,Bean对象都创建成功");
		isRunning = true;
	}

	@Override
	public void stop() {
		System.out.println("关闭");
	}

	@Override
	public boolean isRunning() { // 当running = true的时候，才会在容器关闭的时候调用stop()方法
		return isRunning;
	}
}
