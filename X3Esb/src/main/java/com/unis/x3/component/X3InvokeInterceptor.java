package com.unis.x3.component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.unis.x3.model.common.ErrorMsg;

import cn.hutool.core.codec.Base64;

/**
 * 
 * @author 胡晓聪
 * @description 拦截器,控制mes用户才可以访问
 *
 */
public class X3InvokeInterceptor implements HandlerInterceptor {
	
@Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
	
	 String authorization = request.getHeader("Authorization");
     if (authorization == null || !authorization.startsWith("Basic ")) {
         throw new ServletException(ErrorMsg.ERR_003);
     }
     //获取base64加密的用户名:密码
     String token = authorization.substring(6);
     String tokenDecode = new String(Base64.decode(token));
     String user = tokenDecode.split(":")[0];
     String pwd = tokenDecode.split(":")[1];
     //这里是写死的用户名密码去比对,这里可以引入一个LoginService去数据库验证权限
     if("mes".equalsIgnoreCase(user) && "MES2020".equals(pwd)) {
    	 return true;
     }
     throw new ServletException(ErrorMsg.ERR_003);
}
}
