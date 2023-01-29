package com.zhouyu.boot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName WebServerAutoConfiguration.java
 * @Description TODO
 * @createTime 2022年12月12日 13:25:00
 */
@Configuration
public class WebServerAutoConfiguration {

	@Bean
	@ConditionalOnClass("org.apache.catalina.startup.Tomcat")
	public TomcatWebServer tomcatWebServer(){
		return new TomcatWebServer();
	}

	@Bean
	@ConditionalOnClass("org.eclipse.jetty.server.Server")
	public JettyWebServer jettyWebServer(){
		return new JettyWebServer();
	}
}
