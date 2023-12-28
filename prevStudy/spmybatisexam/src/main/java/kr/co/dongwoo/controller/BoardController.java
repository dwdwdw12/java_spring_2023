package kr.co.dongwoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.dongwoo.repository.BoardDAO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardDAO dao;
	
	
	@RequestMapping(value="/BoardList.bo")
	public String boardList() {
		
		return "/board/qna_board_list";
	}
	
	
	
}
