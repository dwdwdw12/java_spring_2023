package com.zerock.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.zerock.domain.BoardVO;
import com.zerock.domain.Criteria;

public interface BoardMapper {

	//전체 데이터 조회
	//@Select("select * from tbl_board where bno>0")		//index를 염두에 둔 sql문
	public List<BoardVO> getList();
	
	//insert문 bno(pk)값 알 필요없을 때
	public void insert(BoardVO vo);
	
	//insert문 bno값 알 필요 있을 때
	public void insertSelectKey(BoardVO vo);
	
	//bno로 데이터 조회
	public BoardVO read(Long bno);
	
	//bno값으로 데이터 삭제
	public int delete(Long bno);
	
	//bno 업데이트
	public int update(BoardVO vo);
	
	//paging 처리
	public List<BoardVO> getListWithPagging(Criteria cri);
	
	//전체 갯수 구하기
	public int getTotalCount(Criteria cri);
	
	//test
	public List<BoardVO> searchTest(Map<String, Map<String, String>> map);
	
}
