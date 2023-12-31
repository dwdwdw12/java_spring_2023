package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.Log4jAdvice;
import com.springbook.biz.common.LogAdvice;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAO boardDAO;

//	private LogAdvice log;
//	private Log4jAdvice log4j;
	
	public BoardServiceImpl() {
//		log = new LogAdvice();
//		log4j = new Log4jAdvice();
	}
	
	public void insertBoard(BoardVO vo) {
		//log.pringLog();
		//log4j.printLogging();
		boardDAO.insertBoard(vo);
	}

	public void updateBoard(BoardVO vo) {
		//log.pringLog();
		//log4j.printLogging();
		boardDAO.updateBoard(vo);
	}

	public void deleteBoard(BoardVO vo) {
		//log.pringLog();
		//log4j.printLogging();

		boardDAO.deleteBoard(vo);
	}

	public BoardVO getBoard(BoardVO vo) {
		//log.pringLog();
		//log4j.printLogging();

		return boardDAO.getBoard(vo);
	}

	public List<BoardVO> getBoardList(BoardVO vo) {
		//log.pringLog();
		//log4j.printLogging();

		return boardDAO.getBoardList(vo);
	}
}
