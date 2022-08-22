package com.zhouyu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

/**
 * @author wzy
 * @version 1.0.0
 * @ClassName Teacher.java
 * @Description 用于测试依赖注入功能
 * @createTime 2022年08月16日 20:19:00
 */
@Controller
public class TeacherController {

	@Autowired
	private User user;

	private Person person;

	private UserService userService;

	@Value("${zhouyu}") // 占位符填充
	private String name;

	public void setPerson(Person person) {
		this.person = person;
	}

	@Autowired
	public void xxx(UserService userService) {
		this.userService = userService;
	}
}
