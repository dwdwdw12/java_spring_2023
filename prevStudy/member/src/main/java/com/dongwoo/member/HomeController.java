package com.dongwoo.member;

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

import com.dongwoo.member.domain.MemberVO;
import com.dongwoo.member.service.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
///추가	
	@Autowired
	private MemberService service;
///추가	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)	//@GetMapping과 같음	value="/"	->뒤에 /가 붙으면 /WEB-INF/views/dongwoo.jsp로 이동. if문과 비슷
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		//return "dongwoo";	// /WEB-INF/views/dongwoo.jsp
		//return "memberjoin";	//일반적으로 문자열으로 반환됨
		return "home";	//완성된 내용=> /WEB-INF/views/home.jsp 해당 위치 확인하기
	}
		@RequestMapping(value = "/test", method = RequestMethod.GET)	// /test로 변경
		public String test(Locale locale, Model model) {				// 클래스명도 test로 변경
			logger.info("Welcome home! The client locale is {}.", locale);
			
			Date date = new Date();
			DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
			
			String formattedDate = dateFormat.format(date);
			
			model.addAttribute("serverTime", formattedDate );
			
			return "test";	// /WEB-INF/views/home.jsp
	}
		
		@RequestMapping(value = "/member", method = RequestMethod.GET)	
		public String member(Locale locale, Model model) {		// model(인터페이스)- 데이터를 넘겨줄 필요가 있을 때 사용		
			return "memberjoin";	// /WEB-INF/views/home.jsp
	}
		@RequestMapping(value = "/memberjoin"/*, method = RequestMethod.POST*/) //post방식으로 변경시 error발생(memberjoin.jsp에서는 get방식을 사용했으므로)
		public String memberjoin(MemberVO vo, Model model) {	// 결과를 memberVO로 받아줌.		
			//입력폼에서 입력된 데이터를 넘겨받아서 
			//서비스 클래스에게 입력에 필요한 작업을 하도록 지시하고, 그 결과를 받는다.
			int rtnValue = service.add(vo);
			//받은 결과를 응답페이지에서 필요하다면 모델에 넣어준다.
			model.addAttribute("result",rtnValue);	//model에 값을 집어넣어줄때
			model.addAttribute("memberName",vo.getMemName());
			System.out.println(vo);
			return "memberjoinResult";	// /WEB-INF/views/home.jsp
	}	
		
	
	
}
