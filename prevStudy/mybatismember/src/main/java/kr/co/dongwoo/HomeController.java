package kr.co.dongwoo;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.dongwoo.dao.MemberDAO;
import kr.co.dongwoo.vo.MemberVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private MemberDAO dao;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)	
	public String member() {		// model(인터페이스)- 데이터를 넘겨줄 필요가 있을 때 사용		
		return "memberjoin";	// /WEB-INF/views/home.jsp
	}
	
	@RequestMapping(value = "/membersave") 
	public String memberjoin(MemberVO vo, Model model) {		

		int rtnValue = dao.addMember(vo);
		model.addAttribute("result",rtnValue);	
		model.addAttribute("memberName",vo.getMemName());
		System.out.println(vo);
		return "memberjoinresult";	
	}	
	
}
