package com.unis.x3.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.unis.x3.model.common.ErrorMsg;
import com.unis.x3.model.common.Result;
/**
 * 
 * @author 胡晓聪
 * @description  全局异常处理
 *
 */
@RestControllerAdvice
public class GlobalExceptionAdvice {
	 @ExceptionHandler(Exception.class)
	    public Result handleException(Exception e) {
		 if (e instanceof NoHandlerFoundException) {
	            //404 Not Found
	            return new Result(false, ErrorMsg.ERR_004);
	        } 
	        return new Result(false, e.getMessage());
	    }
}
