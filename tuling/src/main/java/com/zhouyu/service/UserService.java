package com.zhouyu.service;


import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author 周瑜
 */
@Component
//@Scope("prototype")
public class UserService {

	public void test() {

		System.out.println("test");
	}

	public void a() {

		System.out.println("a");
	}

	/**
	 * 事件监听器，实现二：
	 * @EventListener
	 * @param applicationEvent
	 */
//	@EventListener
//	public void listener(ApplicationEvent applicationEvent){
//		System.out.println(applicationEvent);
//	}


}
