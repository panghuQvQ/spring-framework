package com.zhouyu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName User.java
 * @Description TODO
 * @createTime 2022年07月14日 15:48:00
 */
@Component
public class User {

	@Autowired
	User user;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Transactional
	public String test() {
		jdbcTemplate.execute("insert into student values(4,'小王','男')");

		try {
			user.test1();
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly(); // 强制回滚
			return "新增失败";
		}
		return "新增成功";
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void test1() {
		jdbcTemplate.execute("insert into student values(5,'小花','女')");
		int result = 100 / 0;
	}
}
