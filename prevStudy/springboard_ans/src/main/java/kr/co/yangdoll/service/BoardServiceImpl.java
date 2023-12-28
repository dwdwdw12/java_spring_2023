package kr.co.yangdoll.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.yangdoll.domain.BoardBean;
import kr.co.yangdoll.domain.PageDTO;
import kr.co.yangdoll.repository.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired // 자바에서 제공하는 @Inject(타입), @Resource(이름) 의 어노테이션도 있다.
	private BoardDAO dao;

	@Override
	public List<BoardBean> boardList(int start, int end) {
		// TODO Auto-generated method stub
		return dao.boardList(start, end);
	}

	@Override
	public int boardCount() {
		// TODO Auto-generated method stub
		return dao.boardCount();
	}

	@Override
	public PageDTO pageCalcu(HttpServletRequest request, int boardCount) {
		int page = request.getParameter("page") == null? 1: Integer.parseInt(request.getParameter("page"));
		int limit = request.getParameter("limit") == null? 10: Integer.parseInt(request.getParameter("limit"));;
		PageDTO paging = new PageDTO();
		paging.calcu(page, limit, boardCount);  
		return paging;
	}

	@Override
	public int boardAdd(BoardBean board) {
		int num = dao.maxNum() + 1;
		board.setBOARD_NUM(num);
		board.setBOARD_RE_REF(num);
		return dao.boardAdd(board);
	}

	@Override
	public BoardBean boardDetail(int num) {
		
		return dao.boardDetail(num);
	}

	@Override
	public int boardReply(BoardBean board) {
		int num = dao.maxNum() + 1;
		dao.seqUpdate(board.getBOARD_RE_REF(), board.getBOARD_RE_SEQ());
		board.setBOARD_NUM(num);
		board.setBOARD_RE_LEV(board.getBOARD_RE_LEV()+1);
		board.setBOARD_RE_SEQ(board.getBOARD_RE_SEQ()+1);
		dao.boardAdd(board);
		return num;
	}

	@Override
	public int boarModify(BoardBean board) {
		
		return dao.boarModify(board);
	}

	@Override
	public int boarDelete(int num) {
		// TODO Auto-generated method stub
		return dao.boarDelete(num);
	}

}
