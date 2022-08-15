package com.zhouyu.service;

import org.springframework.stereotype.Service;

/**
 * @author 周瑜
 */
//@Service
public class StudentService {

	private User user;

	public void test() {

		System.out.println("student");
	}

	/**
	 * 可以不写属性，只写set() 方法
	 * setUser()后的User 为属性的名字, 入参 User 为属性的类型
 	 */
	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}
}
