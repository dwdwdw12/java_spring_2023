package org.zerock.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler{@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication auth) throws IOException, ServletException {
	
		log.info("Login Success");
		System.out.println("sysout login Success");
		
		List<String> roleNames = new ArrayList<String>();
		
		auth.getAuthorities().forEach(auth2 -> roleNames.add(auth2.getAuthority()));
		log.info("authentication: " + auth.getName());
		log.info(auth.getPrincipal().toString());
		log.info("Role Names : " + roleNames);
		
		if(roleNames.contains("ROLE_ADMIN")) {
			response.sendRedirect("/sample/admin");				//로그인 성공시의 동작을 지정 가능
			return;
		} else if(roleNames.contains("ROLE_MEMBER")){
			response.sendRedirect("/sample/member");
			return;
		}
		
		response.sendRedirect("/");	//메인페이지로 넘기기
		
	}

}
