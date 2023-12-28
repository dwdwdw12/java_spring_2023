package com.dongwoo.member.dao;

import java.util.List;

import com.dongwoo.member.domain.BoardVO;

public interface BoardDAO {
	int saveBoard(BoardVO vo);
	int removeBoard(long boardNo);
	int updateBoard(BoardVO vo);
	
	int getCount();
	BoardVO getBoard(long boardNo);
	List<BoardVO> getAll();
	int delAll();
}
