package kr.co.dongwoo.dao;

import java.util.List;

import kr.co.dongwoo.vo.MemberVO;

public interface MemberDAO {
	List<MemberVO> getAllMember();	//전체 회원 조회
	MemberVO getOneMember(String memId);
	int addMember(MemberVO vo);
	int delMember(String memId);
	int updateMember(MemberVO vo);
}
