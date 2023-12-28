package com.dongwoo.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dongwoo.member.service.MemberService;
import com.dongwoo.member.vo.MemberVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private MemberService service;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {	//Locale locale, Model model
		return "home";
	}
	
	@RequestMapping(value = "/inMember")
	public String inMember() {	//Locale locale, Model model
		return "inMember";
	}

	@RequestMapping(value = "/membersave")
	public String membersave(MemberVO vo, Model model) {	//Locale locale, Model model
		//입력폼에서 넘겨준 자료를 vo로 넘겨 받아서 
		//서비스의 입력메서드에게 자료를 전달해준 후 결과값을 정수로 받는다.
		int result = service.membersave(vo);
		model.addAttribute("inCount", result);//속성명, 데이터. 아래 inMemberResult.jsp에 전달.
		model.addAttribute("irum", vo.getMemName());
		return "inMemberResult";
	}
	
	// getMember요청
	@RequestMapping(value="/getMember")
	public String getMember(String memId, Model model) {
		MemberVO resultVo = service.getMember(memId);
		System.out.println(resultVo+"<<컨트롤러에서 받은 최종 결과");
		model.addAttribute("member", resultVo);
		return "getMemberView";
	}
	
	@RequestMapping(value="/delMember")
	public String delMember(String memId, Model model) {
		int result=service.delmember();
		return "delMemberView";
	}
	
	//listMember요청
	@RequestMapping(value="/listMember")
	public String listMember(HttpServletRequest request, Model model,/* HttpServletResponse response,*/ HttpSession session) {
		//request.getHeader("");	//request객체, session 객체 사용 가능
		List<MemberVO> list = service.listMember();
		model.addAttribute("list", list);
		return "listMemberView";
	}
	
	@RequestMapping(value="/serBasicObj")	//접속자의 정보를 얻어옴
	public String serBasicObj(PageContext ctxt, Model model, HttpSession session) {
		List<MemberVO> list = service.listMember();
		session.setAttribute("listSession", list);
		String clientIP = ctxt.getRequest().getRemoteAddr();
		return "serBasicObjView";
	}
	
}
