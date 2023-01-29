package com.zhouyu.boot;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName JettyWebServer.java
 * @Description TODO
 * @createTime 2022年12月12日 13:20:00
 */
public class JettyWebServer implements WebServer{
	@Override
	public void start() {
		System.out.println("Jetty启动");
	}
}
