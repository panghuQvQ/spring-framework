package com.zhouyu.boot;

import org.apache.catalina.*;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardEngine;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.Map;

public class ZhouyuSpringApplication {

	public static ConfigurableApplicationContext run(Class config) {
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
		applicationContext.register(config);
		applicationContext.refresh();

		// pom.xml  @Conditional 启动一个tomcat
//		startTomcat(applicationContext);

		// 假如需要除 Tomcat 以外的服务器，如 Jetty、Undertow
		WebServer webServer = getWebServer(applicationContext);
		webServer.start();
		return applicationContext;

	}

	private static WebServer getWebServer(AnnotationConfigWebApplicationContext applicationContext) {

//		WebServer webServer = applicationContext.getBean(WebServer.class);

		//key 为beanName， value 为Bean对象
		Map<String, WebServer> webServers = applicationContext.getBeansOfType(WebServer.class);
		if(webServers.isEmpty()){
			throw new NullPointerException("未配置服务器");
		}
		if(webServers.size()>1){
			try {
				throw new IllegalAccessException("拿到了多个服务器");
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return webServers.values().stream().findFirst().get();
	}

	private static Tomcat startTomcat(AnnotationConfigWebApplicationContext applicationContext) {
		Tomcat tomcat = new Tomcat();

		Server server = tomcat.getServer();
		Service service = server.findService("Tomcat");

		Connector connector = new Connector();
		connector.setPort(8081);

		Engine engine = new StandardEngine();
		engine.setDefaultHost("localhost");

		Host host = new StandardHost();
		host.setName("localhost");

		String contextPath = "";
		Context context = new StandardContext();
		context.setPath(contextPath);
		context.addLifecycleListener(new Tomcat.FixContextListener());

		host.addChild(context);
		engine.addChild(host);

		service.setContainer(engine);
		service.addConnector(connector);

		DispatcherServlet dispatcherServlet = applicationContext.getBean(DispatcherServlet.class);
		tomcat.addServlet(contextPath, "dispatcher", dispatcherServlet);
		context.addServletMappingDecoded("/*", "dispatcher");

		try {
			tomcat.start();
		} catch (LifecycleException e) {
			e.printStackTrace();
		}

//		Thread thread = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				tomcat.getServer().await();
//			}
//		});
//		thread.setDaemon(false);
//		thread.start();

		return tomcat;
	}


}
