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

	/**
	 * AOP 总结：
	 *  Advisor
	 * 		Pointcut
	 * 			ClassFilter
	 * 			MethodMatcher
	 * 		Advice---> Method拦截器(方法前，方法后，异常后。。。)
	 *  UserService --> 找到所有匹配的Advisor --> 利用ProxyFactory 生成代理对象
	 *  代理对象执行某个方法时 --> 依据当前调用的方法 --> 找到所匹配的Advisor --> 并执行对应的Advice逻辑
	 *===============================================================================================
	 *
	 * Spring 事务总结：
	 *	test()
	 *	Spring 事务管理器，创建数据库连接 conn
	 *	conn.autocommit = false;
	 *	conn.隔离级别
	 *	conn放入ThreadLocal<Map> ==> DataSource,conn 连接
	 *	target.test() sql1,sql2
	 *		a()
	 *			挂起---> 挂起对象.conn连接
	 *			Spring 事务管理器，创建数据库连接 conn1
	 * 	  		conn1.autocommit = false;
	 * 	  		conn1.隔离级别
	 * 	  		conn1放入ThreadLocal<Map> DataSource,conn1 连接
	 * 	  		sql
	 * 	  		conn1.提交
	 * 	  		恢复---> 挂起对象.conn连接---> ThreadLocal<Map>
	 * 	  		rollback()---> true---> ThreadLocal true
	 * 	  	sql3
	 * 	提交---> commit()--->ThreadLocal true---> 回滚
	 *
	 */
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
