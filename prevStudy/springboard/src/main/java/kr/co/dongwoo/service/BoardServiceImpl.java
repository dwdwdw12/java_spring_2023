package kr.co.dongwoo.service;

import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dongwoo.domain.BoardBean;
import kr.co.dongwoo.domain.PageDTO;
import kr.co.dongwoo.repository.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired	//spring에서 제공하는 @Autowired, 자바에서 제공하는 @Inject(타입) @Resource(이름) 의 어노테이션도 있다.
	private BoardDAO dao;
	
	@Override
	public List<BoardBean> boardList(int start, int end) {
		return dao.boardList(start, end);
	}

	@Override
	public int boardCount() {
		
		return dao.boardCount();
	}

	@Override
	public PageDTO getCalcu(HttpServletRequest request, int boardCount) {
		int page = request.getParameter("page")==null?1:Integer.parseInt(request.getParameter("page"));
		int limit = request.getParameter("limit")==null?10/*1*/:Integer.parseInt(request.getParameter("limit"));;
		
		PageDTO paging = new PageDTO();
		paging.calcu(page, limit, boardCount);
		return paging;
	}

	@Override
	public int boardAdd(BoardBean board) {
		int num = dao.maxNum()+1;
		board.setBOARD_NUM(num);
		board.setBOARD_RE_REF(num);
		return dao.boardAdd(board);
	}

	@Override
	public BoardBean boardDetail(int number) {
		
		return dao.boardDetail(number);
	}

	@Override
	public int boardDelete(int number) {
//		BoardDAO boarddao=new BoardDAO();
//		boolean usercheck=false;
//		usercheck=boarddao.isBoardWriter(num, request.getParameter("BOARD_PASS"));
//	   	
//	   	if(usercheck==false){
//	   	
//	   		PrintWriter out=response.getWriter();
//	   		out.println("<script>");
//	   		out.println("alert('비밀번호가 일치하지 않습니다.');");
//	   		out.println("location.href='./BoardList.bo';");
//	   		out.println("</script>");
//	   		out.close();
//	   		return null;
//	   	}
		return dao.boardDelete(number);
	}

	@Override
	public String isBoardWriter(int number) {
		return dao.isBoardWriter(number);
	}

	@Override
	public int boardModify(BoardBean board, int number) {
		return dao.boardModify(board, number);
	}

	@Override
	public int boardReply(BoardBean board) {
		int num = dao.maxNum()+1;
		return dao.boardReply(board, num);
	}

	@Override
	public int seqModify(BoardBean board) {
		
		return dao.seqModify(board) ;
	}

	@Override
	public int readCount(int number) {
		
		return dao.readCount(number);
	}

}
