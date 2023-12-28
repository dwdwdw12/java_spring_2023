package com.dongwoo.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dongwoo.member.service.BoardService;

@Controller
@RequestMapping("/board/")	//공통적인 내용 미리 작성
public class BoardController {
//	
//	@Autowired
//	BoardService service;
//	
//	//board/insert에 요청이 들어오면 => 최종 결과물을 보여줄 jsp 페이지를 결정(insertResult.jap->view)
//	@RequestMapping("/insert")	//=> /board//insert/		슬래시는 1개 이상. 
//	public String insert(/*필요한 테이터 명세를 나열*/ Model model/*Model model, HttpSession session,*/ /*처리된 결과가 view에서 필요한지*/) {
//		int result = service.insert(); 
//		return "insertResult";
//	}	
//	
//	//board/get이 들어오면
//	@RequestMapping("/get")	//온전한 요청 = /board//get
//	public String get(){
//		return "/board/get";
//	}	//반환되는 타입이 void면 "온전한 요청"을 반환한다. => return "/board/get" =>접두어 + /board/get + 접미어
//	
//	
//	//board/delAll이 들어오면../
//
//	//board.delOne

}
