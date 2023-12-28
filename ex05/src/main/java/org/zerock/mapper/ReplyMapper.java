package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

public interface ReplyMapper {
	//create
	public int insert(ReplyVO vo);
	//read
	public ReplyVO read(Long rno);
	//delete
	public int delete(Long rno);
	//update
	public int update(ReplyVO vo);
	
	public List<ReplyVO> getListWithPaging(
			@Param("cri") Criteria cri,
			@Param("bno") Long bno
			);
	
	public int getCountByBno(Long bno);
	
}
