package org.zerock.service;

import java.util.List; 

import org.springframework.stereotype.Service;
import org.zerock.mapper.BoardMapper;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

	private final BoardMapper boardMapper;	//autowired가 없어도 자동으로 주입됨.
	
//	@Override
//	public List<BoardVO> getList() {
//		log.info("getList...");
//		return boardMapper.getList();
//	}
	
	@Override
	public List<BoardVO> getList(Criteria criteria) {
		log.info("getListWithPagging..." + criteria);
		return boardMapper.getListWithPagging(criteria);
	}

	@Override
	public BoardVO get(Long bno) {
		log.info("get...");
		return boardMapper.read(bno);
	}

	@Override
	public void register(BoardVO board) {
		log.info("register..." + board);
		boardMapper.insertSelectKey(board);
	}

	@Override
	public boolean modify(BoardVO board) {
		log.info("modify...");
		int result = boardMapper.update(board);
		if(result==1) {
			return true;
		} else {
			return false;			
		}
		
//		return boardMapper.update(board) ==1? true : false;
	}

	@Override
	public boolean remove(Long bno) {
		log.info("remove...");
		int result = boardMapper.delete(bno);
		
		return result ==1;
	}

	@Override
	public int getTotal(Criteria cri) {
		log.info("get total count");
		return boardMapper.getTotalCount(cri);
	}

}
