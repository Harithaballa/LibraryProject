package com.redshift.LibrarApplicationn.Model;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
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
		System.out.println("ENte");

		ObjectMapper mapper=new ObjectMapper();
		String methodName=jp.getSignature().getName();
		String className=jp.getTarget().getClass().toString();
		Object[] args=jp.getArgs();
		logger.info("method invoked "+className+":"+methodName+"()"+"args: "+mapper.writeValueAsString(args));
		Object obj=jp.proceed();
		logger.info(className+":"+methodName+"()"+"Return value"+mapper.writeValueAsString(obj));
		return obj;
	}
}
