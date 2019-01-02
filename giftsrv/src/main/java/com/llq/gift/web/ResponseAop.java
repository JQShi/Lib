package com.llq.gift.web;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

//@Component
//@Aspect
public class ResponseAop {

	@Pointcut("execution(public * com.llq.gift.web.*Controller.*(..))")
    public void webLog(){}
//	
//	@AfterReturning(returning = "ret",pointcut = "webLog()")
//    public void doAfterReturning(Object ret) throws Throwable {
//        // 处理完请求，返回内容
//        //logger.info("RESPONSE : " + ret);
//    }

	@Around(value = "webLog()")  
	public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){  
//	    logger.info("环绕通知的目标方法名："+proceedingJoinPoint.getSignature().getName());  
	    try {  
	    	Object[] args = proceedingJoinPoint.getArgs();
	    	String method = (String) args[0];
	    	System.out.println("working...");
	        Object obj = proceedingJoinPoint.proceed();  
	        Map<String, Object> rsp = new HashMap<>();
	        rsp.put(method, obj);
	        rsp.put("success", Boolean.TRUE);
	        return rsp;  
	    } catch (Throwable throwable) { 
	    	System.out.println("error happened...");
	        throwable.printStackTrace(); 
	        Map<String, Object> rsp = new HashMap<>();
//	        rsp.put(method, obj);
	        rsp.put("success", Boolean.FALSE);
	    }  
	    return null;  
	} 
	
}
