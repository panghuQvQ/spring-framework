package com.zhouyu;

import com.zhouyu.service.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName TestConfig.java
 * @Description TODO
 * @createTime 2022年12月16日 11:00:00
 */
@Configuration
public class TestConfig {

	@Bean
	StudentService studentService(){
		return new StudentService();
	}

}
