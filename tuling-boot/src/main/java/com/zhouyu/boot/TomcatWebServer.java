package com.zhouyu.boot;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName TomcatWebServer.java
 * @Description TODO
 * @createTime 2022年12月12日 13:19:00
 */
public class TomcatWebServer implements WebServer{
	@Override
	public void start() {
		System.out.println("tomcat启动");
	}
}
