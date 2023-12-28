package com.ezen.mybatis.project;

import java.util.List;

public interface MapperInterface {
	
	public MemberVO selectOne(int id);
	
	public int insertMember(MemberVO mVo);
	
	public int deleteMember(int id);
	
	public int updateMember(MemberVO mVo);
	
	public List<MemberVO> selectAll();

}
