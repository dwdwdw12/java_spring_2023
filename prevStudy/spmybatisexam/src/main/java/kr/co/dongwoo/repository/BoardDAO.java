package kr.co.dongwoo.repository;

import java.util.List;

import kr.co.dongwoo.vo.BoardVO;

public interface BoardDAO {

	List<BoardVO> boardList(int start, int end);

	int boardCount();

	int maxNum();

	BoardVO boardDetail(int board_num);

	int boardAdd(BoardVO vo);

	int boardDelete(int board_num);

	int boardModify(BoardVO vo);
//////////////////////////////////////////////////////
	int seqModify(BoardVO vo);

	int readCount(int board_num);

	int boardReply(BoardVO vo);
	
//	BoardVO boardPassword(int board_num);
  
}
