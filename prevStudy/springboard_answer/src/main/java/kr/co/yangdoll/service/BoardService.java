package kr.co.yangdoll.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.co.yangdoll.domain.BoardBean;
import kr.co.yangdoll.domain.PageDTO;

public interface BoardService {

	List<BoardBean> boardList(int start, int end);

	int boardCount();

	PageDTO pageCalcu(HttpServletRequest request, int boardCount);

	int boardAdd(BoardBean board);

	BoardBean boardDetail(int num);

	int boardReply(BoardBean board);

	int boarModify(BoardBean board);

	int boarDelete(int num);

}
