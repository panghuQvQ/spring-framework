package com.zhouyu;

import com.zhouyu.service.UserService;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.cglib.proxy.*;

import java.lang.reflect.Method;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName AopTest.java
 * @Description AOP 测试类
 * @createTime 2022年09月13日 10:53:00
 */
public class AopTest {

	private static UserService userService;

	public static void main(String[] args) {


		UserService target = new UserService();

		/*// 通过cglib技术实现动态代理
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(UserService.class);

		// 定义额外逻辑，也就是代理逻辑
		enhancer.setCallbacks(new Callback[]{new MethodInterceptor() {
			@Override
			public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

				System.out.println("before...");

				Object result = methodProxy.invoke(target, objects);
				System.out.println("after...");
				return result;
			}
		}, NoOp.INSTANCE}); // 此处表示拦截器集合中有两个拦截器 , NoOp.INSTANCE 表示无操作的拦截器

		enhancer.setCallbackFilter(new CallbackFilter() {
			@Override
			public int accept(Method method) {

				if (method.getName().equals("test")) {
					return 0; // 表示执行上面Callback[] 下标为 0 的拦截器
				} else {
					return 1; // 表示执行上面Callback[] 下标为 1 的拦截器
				}
			}
		});

		// 动态代理所创建出来的UserService 对象
		UserService userService = (UserService) enhancer.create();

		// 执行这个userService的test方法时，就会额外汇之星一些其他逻辑
		userService.a();*/

		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(target);

		UserService userService = (UserService) proxyFactory.getProxy();
		userService.test();

	}
}
