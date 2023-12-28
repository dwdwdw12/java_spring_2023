package kr.co.dongwoo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.dongwoo.domain.BoardBean;
import kr.co.dongwoo.domain.PageDTO;
import kr.co.dongwoo.repository.BoardDAO;
import kr.co.dongwoo.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;

	@RequestMapping(value = "/BoardList.bo")
	public String boardList(HttpServletRequest request,/*String pageStr, String limitStr,*/ Model model){	//int page로 받으면 page가 null일때 처리하지 못함. error
		//System.out.println("page: " + page);
		//System.out.println("model: " + model);	//오류 체크
		
		/*int page =1;
		int limit = 10;
		if(pageStr!=null) page=Integer.parseInt(pageStr);	//{}생략
		if(limitStr!=null) limit=Integer.parseInt(limitStr);
		int boardCount = service.boardCount();
		PageDTO paging = new PageDTO();
		paging.calcu(page, limit, boardCount);*/
		
		int boardCount = service.boardCount();
		PageDTO paging = service.getCalcu(request, boardCount);
		List<BoardBean> list = service.boardList(paging.getStartNum(), paging.getEndNum());
		
		model.addAttribute("paging", paging);
		model.addAttribute("boardCount",boardCount); 
		model.addAttribute("list", list);	
		
		return "/board/qna_board_list";
	}
	
	@RequestMapping(value = "/BoardWrite.bo")
	public String boardWrite() {
		return "redirect:/BoardWriteForm.bo";	//중계과정
	}
	
	@RequestMapping(value = "/BoardWriteForm.bo")
	public String boardWriteForm() {
		return "/board/qna_board_write";		//WEB-INF파일에 바로 redirecting 할 수 없음. 반드시 controller를 거쳐야 함
	}

	@PostMapping(value = "/BoardAddAction.bo")
	public String boardAdd(BoardBean board) {
//		System.out.println(board.getBOARD_NAME());
//		System.out.println(board.getBOARD_SUBJECT());
//		System.out.println(board.getBOARD_CONTENT());
//		System.out.println(board.getBOARD_PASS());
//		System.out.println(board.getBOARD_RE_LEV());
		int result = service.boardAdd(board);
		if(result==0) {
			System.out.println("입력 실패");
		}
		return "redirect:/BoardList.bo";		
	}

	
	@RequestMapping(value = "/BoardDetailAction.bo")
	public String BoardDetailAction(HttpServletRequest request, Model model) {
		int number=Integer.parseInt(request.getParameter("num"));
		int readCount = service.readCount(number);
		BoardBean board = service.boardDetail(number);
		if(board==null) {
			System.out.println("조회 실패");
		}
		model.addAttribute("board", board);
		
		
		return "/board/qna_board_view";	//중계과정
	}
	
	
	@RequestMapping(value = "/BoardDelete.bo")
	public String boardDeleteMove() {
		return "/board/qna_board_delete";	//중계과정
	}
	
	@RequestMapping(value = "/BoardDeleteAction.bo")
	public String BoardDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int number=Integer.parseInt(request.getParameter("num"));
		String pass = request.getParameter("BOARD_PASS");
		String realPass = service.isBoardWriter(number);
		
		if(pass.equals(realPass)) {
			int result = service.boardDelete(number);
			if(result==0) {
				System.out.println("삭제 실패");
			}
		} else {
			response.setContentType("text/html;charset=utf-8");
	   		PrintWriter out=response.getWriter();
	   		out.println("<script>");
	   		out.println("alert('비밀번호가 일치하지 않습니다.');");
	   		out.println("location.href='./BoardList.bo';");
	   		out.println("</script>");
	   		out.close();
		}
		return "redirect:/BoardList.bo";	
	}
	
	@RequestMapping(value = "/BoardModify.bo")
	public String boardModifyMove(HttpServletRequest request, Model model) {
		int number=Integer.parseInt(request.getParameter("num"));
		BoardBean board = service.boardDetail(number);
		model.addAttribute("board", board);
		return "/board/qna_board_modify";	
	}
	
	@RequestMapping(value = "/BoardModifyAction.bo")
	public String BoardModify(HttpServletRequest request, HttpServletResponse response, BoardBean board) throws IOException {
		int number=Integer.parseInt(request.getParameter("BOARD_NUM"));
		String pass = request.getParameter("BOARD_PASS");
		String realPass = service.isBoardWriter(number);
		
		if(pass.equals(realPass)) {
			int result = service.boardModify(board, number);
			if(result==0) {
				System.out.println("수정 실패");
			}
		} else {
			response.setContentType("text/html;charset=utf-8");
	   		PrintWriter out=response.getWriter();
	   		out.println("<script>");
	   		out.println("alert('비밀번호가 일치하지 않습니다.');");
	   		out.println("location.href='./BoardList.bo';");
	   		out.println("</script>");
	   		out.close();
		}
		//model.addAttribute("board", board);
		
		
		return "redirect:/BoardList.bo";
	}
	
	@RequestMapping(value = "/BoardReplyView.bo")
	public String boardReplyMove(HttpServletRequest request, Model model) {
		int number=Integer.parseInt(request.getParameter("num"));
		BoardBean board = service.boardDetail(number);
		model.addAttribute("boarddata", board);
		return "/board/qna_board_reply";	
	}
	
	@RequestMapping(value = "/BoardReplyAction.bo")
	public String BoardReplyView(BoardBean board) {
		int seqMod = service.seqModify(board);
		int result = service.boardReply(board);
		if(result==0) {
			System.out.println("답변 실패");
		} 
		
		return "redirect:/BoardList.bo";
	}
}
