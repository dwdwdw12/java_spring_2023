package com.dongwoo.member.dao;

import java.util.List;

import com.dongwoo.member.vo.MemberVO;

public interface MemberDAO {

	int membersave(MemberVO vo);

	MemberVO getMember(String memId);

	int delMember();

	List<MemberVO> listMember();

}
