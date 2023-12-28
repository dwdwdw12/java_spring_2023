package org.zerock.service;

import java.util.List;  

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardService {
	
//	public List<BoardVO> getList();
	
	public List<BoardVO> getList(Criteria criteria);
	
	public BoardVO get(Long bno);
	
	public void register(BoardVO board);	//insert
	
	public boolean modify(BoardVO board);	//update
	
	public boolean remove(Long bno);		//delete
	
	public int getTotal(Criteria cri);
}
