package com.dongwoo.member.dao;

import java.util.List;

import com.dongwoo.member.domain.MemberVO;

public interface MemberDAO {
	int insertMember(MemberVO vo);	
	int deleteMember(String memId);	//primary key인 memId로 삭제
	int updateMember(MemberVO vo);
	MemberVO getMember(String memId);	//반환타입은 MemberVO //1사람만 조회할 것이므로 memId를 사용
	List<MemberVO> getAllMember();		//반환값이 다양.
	
	int deleteAll();	//delete from members
	int getCount();		//select count(*) from members
}
