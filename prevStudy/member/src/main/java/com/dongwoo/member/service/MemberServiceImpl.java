package com.dongwoo.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dongwoo.member.dao.MemberDAO;
import com.dongwoo.member.domain.MemberVO;

//@Service
public class MemberServiceImpl implements MemberService {
	//@Autowired	-> 사용시 setter 필요없음
	MemberDAO dao;

	public void setDao(MemberDAO dao) {
		//필요에 따라서 선행 작업이 이루어진다....... 서비스에서 따로 만드는 이유.
		this.dao = dao;
	}

	@Override
	public int add(MemberVO vo) {
		//필요에 따라서 선행 작업이 이루어진다.
		return dao.insertMember(vo);
	}

	@Override
	public int del(String memId) {
		//필요에 따라서 선행 작업이 이루어진다.
		return dao.deleteMember(memId);
	}

	@Override
	public int update(MemberVO vo) {
		//필요에 따라서 선행 작업이 이루어진다.
		return dao.updateMember(vo);
	}

	@Override
	public List<MemberVO> listAll() {
		//필요에 따라서 선행 작업이 이루어진다.
		return dao.getAllMember();
	}
	
	
	
	
}
