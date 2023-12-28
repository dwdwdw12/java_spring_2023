package com.dongwoo.member.service;

import java.util.List;

import com.dongwoo.member.vo.MemberVO;

public interface MemberService {

	int membersave(MemberVO vo);

	MemberVO getMember(String memId);

	int delmember();

	List<MemberVO> listMember();

}
