package com.llq.gift.web;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.NativeWebRequest;

import com.llq.gift.vo.BaseResponse;

@RestControllerAdvice
public class BaseControllerAdvice {

	
	 @ExceptionHandler()    
//	    @ResponseStatus(HttpStatus.UNAUTHORIZED)    
    public BaseResponse<Object> processException(NativeWebRequest request, Exception e) {    
//        System.out.println("===========应用到所有@RequestMapping注解的方法，在其抛出UnauthenticatedException异常时执行"); 
        BaseResponse<Object> rsp = new BaseResponse<>("1", e.getMessage());
        return rsp; //返回一个逻辑视图名    
    }    
	
}
