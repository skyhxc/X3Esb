package com.unis.x3.component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.unis.x3.model.common.ErrorMsg;

import cn.hutool.core.codec.Base64;

/**
 * 
 * @author ������
 * @description ������,����mes�û��ſ��Է���
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
     //��ȡbase64���ܵ��û���:����
     String token = authorization.substring(6);
     String tokenDecode = new String(Base64.decode(token));
     String user = tokenDecode.split(":")[0];
     String pwd = tokenDecode.split(":")[1];
     //������д�����û�������ȥ�ȶ�,�����������һ��LoginServiceȥ���ݿ���֤Ȩ��
     if("mes".equalsIgnoreCase(user) && "MES2020".equals(pwd)) {
    	 return true;
     }
     throw new ServletException(ErrorMsg.ERR_003);
}
}
