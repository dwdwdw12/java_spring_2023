package com.dongwoo.member.service;

import java.util.List;

import com.dongwoo.member.domain.MemberVO;

public interface MemberService {
	int add(MemberVO vo);
	int del(String memId);
	int update(MemberVO vo);
	List<MemberVO> listAll();
}
