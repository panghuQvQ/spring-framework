package com.zhouyu;


import com.zhouyu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@ComponentScan("com.zhouyu")
@PropertySource("spring.properties") // 引用properties文件，后续可用 @Value("$(zhouyu)")
@EnableAspectJAutoProxy // 开启切面
//@EnableAsync
//@EnableTransactionManagement
//@Configuration(proxyBeanMethods = false) // 默认为true
public class AppConfig {

	// 测试 通过 byName 实现依赖注入
	@Bean(autowire = Autowire.BY_NAME)
	public StudentService studentService(){
		return new StudentService();
	}

	// 国际化对象
	@Bean
	public MessageSource messageSource(){
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("message");
		return messageSource;
	}

//	@Bean
//	public JdbcTemplate jdbcTemplate() {
//		return new JdbcTemplate(dataSource());
//	}
//
//
//	@Bean
//	public PlatformTransactionManager transactionManager() {
//		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
//		transactionManager.setDataSource(dataSource());
//		return transactionManager;
//	}
//
//
//	@Bean
//	public DataSource dataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/tuling?characterEncoding=utf-8&useSSL=false");
//		dataSource.setUsername("root");
//		dataSource.setPassword("Zhouyu123456***");
//		return dataSource;
//	}


//	@Bean
//	public SqlSessionFactory sqlSessionFactory() throws Exception {
//		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
//		sessionFactoryBean.setDataSource(dataSource());
//		return sessionFactoryBean.getObject();
//	}


}
