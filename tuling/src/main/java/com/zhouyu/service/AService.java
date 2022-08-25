package com.zhouyu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName AService.java
 * @Description 用于测试循环依赖 --BService
 * @createTime 2022年08月25日 10:34:00
 */
@Component
public class AService {

	@Autowired
	private BService bService;

	public void test(){
		System.out.println(bService);
	}
}
