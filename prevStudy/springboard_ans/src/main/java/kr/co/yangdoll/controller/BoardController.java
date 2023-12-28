package kr.co.yangdoll.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.yangdoll.domain.BoardBean;
import kr.co.yangdoll.domain.PageDTO;
import kr.co.yangdoll.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService service;
	
	@RequestMapping(value = "/BoardList.bo")
	public String boardList( HttpServletRequest request,  Model model) {

		int boardCount = service.boardCount();
		PageDTO paging = service.pageCalcu(request, boardCount);

		List<BoardBean> list = service.boardList(paging.getStartNum(), paging.getEndNum());
		
		model.addAttribute("paging", paging); 
		model.addAttribute("boardCount",boardCount); 
		model.addAttribute("list", list);  
		return "/board/qna_board_list";
	}
	@RequestMapping(value = "/BoardWrite.bo")
	public String boardWrite() {
		return "redirect:/BoardWriteForm.bo";
	}
	
	@RequestMapping(value = "/BoardWriteForm.bo")
	public String boardWriteForm() {
		return "/board/qna_board_write";
	}
	
	@PostMapping(value = "/BoardAddAction.bo")
	public String boardAdd(BoardBean board) {
		int result = service.boardAdd(board);
		if( result == 0 ) {
			System.out.println("입력 실패");
		}
		return "redirect:/BoardList.bo";
	}
	@RequestMapping(value = "/BoardDetailAction.bo")
	public String boardDetail(int num, Model model) {
		// 넘겨받은 num값으로 조회를 한 후에 해당 결과를 view 페이지에 넘겨준다.
		model.addAttribute("board", service.boardDetail(num) );
		return "/board/qna_board_view";
	}
	
	@GetMapping(value="/BoardReplyView.bo")
	public String boardReply(int num, Model model) {
		model.addAttribute("board", service.boardDetail(num));
		return "/board/qna_board_reply";
	}
	@PostMapping("/BoardReplyAction.bo")
	public String boardReply(BoardBean board) {
		int num = service.boardReply(board);
		return "redirect:/BoardDetailAction.bo?num="+num;
	}
	
	@GetMapping(value="/BoardModify.bo")			//get방식과 post방식이 다르면 다른 메서드처럼 동작
	public String boardModify(int num, Model model) {
		model.addAttribute("board", service.boardDetail(num));
		return "/board/qna_board_modify";
	}	
	@PostMapping(value="BoardModify.bo")		//get방식과 post방식에 같은 이름을 주는 경우도 많음.
	public String boardModify(BoardBean board) {
		int result = service.boarModify(board);
		return "redirect:/BoardDetailAction.bo?num="+board.getBOARD_NUM();
	}
	
	@GetMapping(value="/BoardDelete.bo")
	public String boardDelete(int num, Model model) {
		model.addAttribute("board", service.boardDetail(num));
		return "/board/qna_board_delete";
	}
	@PostMapping(value="BoardDeleteAction.bo")
	public String boardDeleteAction(int num) {
		int result = service.boarDelete(num);
		return "redirect:/BoardList.bo";
	}
	
	
	
	
}
