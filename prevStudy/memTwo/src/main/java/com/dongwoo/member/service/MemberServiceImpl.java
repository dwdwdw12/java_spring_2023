package com.dongwoo.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dongwoo.member.dao.MemberDAO;
import com.dongwoo.member.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	MemberDAO dao;

	@Override
	public int membersave(MemberVO vo) {
		return dao.membersave(vo);	//넘겨주기만 하면 됨
	}

	@Override
	public MemberVO getMember(String memId) {
		return dao.getMember(memId);
	}

	@Override
	public int delmember() {
		
		return dao.delMember();
	}

	@Override
	public List<MemberVO> listMember() {
		return dao.listMember();
	}
}
