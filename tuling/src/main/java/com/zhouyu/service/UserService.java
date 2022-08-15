package com.zhouyu.service;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author 周瑜
 */
@Component
@Scope("prototype")
public class UserService {

	public void test() {

		System.out.println("test");
	}


}
