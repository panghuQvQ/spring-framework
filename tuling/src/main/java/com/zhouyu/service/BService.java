package com.zhouyu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName BService.java
 * @Description 用于测试循环依赖 --Aservice
 * @createTime 2022年08月25日 10:35:00
 */
@Component
public class BService {

	@Autowired
	private AService aService;

	public void test(){
		System.out.println(aService);
	}
}
