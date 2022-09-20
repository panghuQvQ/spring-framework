package com.zhouyu.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {

	@Before("execution(public void com.zhouyu.service.UserService.a())")
	public void userServiceAMethodBefore(JoinPoint joinPoint) {
		System.out.println("userServiceBefore");
	}

}
