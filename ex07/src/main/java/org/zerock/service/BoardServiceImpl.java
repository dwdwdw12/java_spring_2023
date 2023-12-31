package org.zerock.service;

import java.util.List; 

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.mapper.BoardAttachMapper;
import org.zerock.mapper.BoardMapper;
import org.zerock.domain.BoardAttachVO;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

	private final BoardMapper boardMapper;	//autowired가 없어도 자동으로 주입됨.
	
	private final BoardAttachMapper attachMapper;
	
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

	@Transactional
	@Override
	public void register(BoardVO board) {
		log.info("register..." + board);
		
		boardMapper.insertSelectKey(board);
		
		if(board.getAttachList()==null||board.getAttachList().size()<=0) {
			return;
		}
		board.getAttachList().forEach(attach->{
			attach.setBno(board.getBno());
			attachMapper.insert(attach);
		});
	}

	@Transactional
	@Override
	public boolean modify(BoardVO board) {
		log.info("modify : " + board);
		
		attachMapper.deleteAll(board.getBno());
		
		boolean modifyResult = boardMapper.update(board)==1;
		
		if(modifyResult&&board.getAttachList()!=null&&board.getAttachList().size()>0) {
			board.getAttachList().forEach(attach->{
				attach.setBno(board.getBno());
				attachMapper.insert(attach);
			});
		}
		
		return modifyResult;
		
//		int result = boardMapper.update(board);
//		if(result==1) {
//			return true;
//		} else {
//			return false;			
//		}
		
//		return boardMapper.update(board) ==1? true : false;
	}

	@Transactional
	@Override
	public boolean remove(Long bno) {
		log.info("remove : " + bno );
//		int result = boardMapper.delete(bno);
		attachMapper.deleteAll(bno);
		return boardMapper.delete(bno) ==1;
	}

	@Override
	public int getTotal(Criteria cri) {
		log.info("get total count");
		return boardMapper.getTotalCount(cri);
	}

	@Override
	public List<BoardAttachVO> getAttachList(Long bno) {
		log.info("get Attach list by bno" + bno);
		return attachMapper.findByBno(bno);
	}

}
