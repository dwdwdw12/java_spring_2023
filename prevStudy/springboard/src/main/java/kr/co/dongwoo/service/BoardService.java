package kr.co.dongwoo.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.co.dongwoo.domain.BoardBean;
import kr.co.dongwoo.domain.PageDTO;

public interface BoardService {

	List<BoardBean> boardList(int start, int end);

	int boardCount();

	PageDTO getCalcu(HttpServletRequest request, int boardCount);

	int boardAdd(BoardBean board);

	BoardBean boardDetail(int number);

	int boardDelete(int number);

	String isBoardWriter(int number);

	int boardModify(BoardBean board, int number);

	int boardReply(BoardBean board);

	int seqModify(BoardBean board);

	int readCount(int number);

}
