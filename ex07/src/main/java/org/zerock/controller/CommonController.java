package org.zerock.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class CommonController {

	@GetMapping("/accessError")			//접근 권한이 없을 경우, 주소창은 바뀌지 않고, 이 페이지로 넘어감
	public void accessDenied(Authentication auth, Model model){
		log.info("access error...");
		model.addAttribute("msg", "Access Denied");
	}
	
	@GetMapping("/customLogin")
	public void loginInput(String error, String logout, Model model) {
		if(error!=null) {
			model.addAttribute("error", "Login error check");
		}
		if(logout !=null) {
			model.addAttribute("logout", "logout");
		}
	}
	
	@GetMapping("/customLogout")
	public void logoutGET() {
		log.info("custom logout");
		
	}
	
}
