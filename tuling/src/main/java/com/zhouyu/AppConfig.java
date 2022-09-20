package com.zhouyu;


import com.zhouyu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;


@ComponentScan("com.zhouyu")
@PropertySource("spring.properties") // 引用properties文件，后续可用 @Value("$(zhouyu)")
@EnableAspectJAutoProxy // 开启切面， 会注册一个 AnnotationAwareAspectJAutoProxyCreator 的PostProcessor
//@EnableAsync
@EnableTransactionManagement
//@Configuration(proxyBeanMethods = false) // 默认为true
@Configuration // 当开启事务时，为保证事务管理器等Bean唯一，需有该注解
public class AppConfig {

	// 测试 通过 byName 实现依赖注入
//	@Bean(autowire = Autowire.BY_NAME)
//	public StudentService studentService() {
//		return new StudentService();
//	}

	// 国际化对象
//	@Bean
//	public MessageSource messageSource() {
//		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//		messageSource.setBasename("message");
//		return messageSource;
//	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}


	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource());
		/**
		 * 默认为true，表示有一个失败的sql就回滚
		 * 设置为false，表示即使部分失败都不会回滚，sql全都执行成功
 		 */
//		transactionManager.setGlobalRollbackOnParticipationFailure(false);
		return transactionManager;
	}


	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=utf-8&useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}


//	@Bean
//	public SqlSessionFactory sqlSessionFactory() throws Exception {
//		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
//		sessionFactoryBean.setDataSource(dataSource());
//		return sessionFactoryBean.getObject();
//	}


}
