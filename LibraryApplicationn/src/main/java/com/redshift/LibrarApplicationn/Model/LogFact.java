package com.redshift.LibrarApplicationn.Model;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;


@Aspect
@Component
public class LogFact {
 
	private static Logger logger=Logger.getLogger(LogFact.class);

	@Pointcut("@annotation(com.redshift.LibrarApplicationn.Model.Logg) && execution(public * *(..) )")
	public void pointcut()
	{
		System.out.println("ENtered");
	}
	
	@Around("pointcut()")
	public Object logginge(ProceedingJoinPoint jp) throws Throwable
	{
		MethodSignature sign=(MethodSignature) jp.getSignature();
	    Method method= sign.getMethod();
		Logg logg=method.getAnnotation(Logg.class);
		String className=jp.getTarget().getClass().getName();
		String methodName=method.getName();
		System.out.println("ENte");
		ObjectMapper mapper=new ObjectMapper();
		Object[] args=jp.getArgs();
		if(logg.enable())
		{
			
			logger.info("method invoked "+className+":"+methodName+"()"+"args: "+mapper.writeValueAsString(args));
			Object obj=jp.proceed();
			logger.info(className+":"+methodName+"()"+"Return value"+mapper.writeValueAsString(obj));
			return obj;
		}
		else {
			Object obj=jp.proceed();
			return obj;
		}
	}
}
