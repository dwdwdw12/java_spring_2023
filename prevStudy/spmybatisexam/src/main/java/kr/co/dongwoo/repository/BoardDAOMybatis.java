package kr.co.dongwoo.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.dongwoo.vo.BoardVO;

@Repository
public class BoardDAOMybatis implements BoardDAO {
	
	@Autowired
	SqlSession session;
	
	String ns = "kr.co.dongwoo.board.";
	
	@Override
	public int boardCount() {
		return session.selectOne(ns+"boardCount");
	}
	
	@Override
	public int maxNum() {
		return session.selectOne(ns+"maxNum");
	}
	
	@Override
	public BoardVO boardDetail(int board_num){
		
		return session.selectOne(ns+"boardDetail", board_num);
	}
	
	@Override
	public int boardAdd(BoardVO vo) {
		return session.insert(ns+"boardAdd",vo);
	}
	
	@Override
	public int boardDelete(int board_num) {
		return session.delete(ns+"boardDelete",board_num);
	}
	
	@Override
	public int boardModify(BoardVO vo) {
		return session.update(ns+"boardModify", vo);
	}
/////////////////////////////////////////////////////////////////////	
	@Override
	public List<BoardVO> boardList(int start, int end) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("end", end);
		return session.selectList(ns+"boardList",map);
	}
	
	@Override
	public int seqModify(BoardVO vo) {
		return session.update(ns+"seqModify",vo);
	}
	
	@Override
	public int readCount(int board_num) {
		return session.update(ns+"readCount", board_num);
	}
	
	@Override
	public int boardReply(BoardVO vo) {
		return session.insert(ns+"boardReply",vo);
	}
	
//	@Override
//	public BoardVO boardPassword(int board_num) {
//		return session.selectOne(ns+"boardPassword",board_num);
//	}
	
}
