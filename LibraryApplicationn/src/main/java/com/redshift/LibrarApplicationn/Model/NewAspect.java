package com.redshift.LibrarApplicationn.Model;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.redshift.LibrarApplicationn.Exception.InvalidIdException;

@Aspect
@Component
public class NewAspect {
	
	private static Logger logger=Logger.getLogger( NewAspect.class);

	@Pointcut("@annotation(com.redshift.LibrarApplicationn.Model.Demo) && execution(public * *(..))")
	public void start() {}
	
	@AfterThrowing(pointcut = "start()" ,throwing = "ex")
	public void demo(Exception ex)
	{
		logger.info("aafter throwing method");
		
	}
	
	
	@Before( "start()")
	public void demos()
	{
		logger.info("controller is started");
	}
	
	@After("start()")
	public void after()
	{
		logger.info("after method");
	}
	
//	@Around("start()")
//	public void around(ProceedingJoinPoint jp)
//	{
//		logger.info("before");
//		try {
//			jp.proceed();
//		} catch (Throwable e) {
//		
//			e.printStackTrace();
//		}
//		logger.info("after");
//	}
}
