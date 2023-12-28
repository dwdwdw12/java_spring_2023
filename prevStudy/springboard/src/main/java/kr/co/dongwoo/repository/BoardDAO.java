package kr.co.dongwoo.repository;

import java.util.List;

import kr.co.dongwoo.domain.BoardBean;

public interface BoardDAO {

	List<BoardBean> boardList(int start, int end);

	int boardCount();

	int boardAdd(BoardBean board);

	int maxNum();

	BoardBean boardDetail(int number);

	int boardDelete(int number);

	String isBoardWriter(int number);

	int boardModify(BoardBean board, int number);

	int boardReply(BoardBean board, int num);

	int seqModify(BoardBean board);

	int readCount(int number);

	

}
