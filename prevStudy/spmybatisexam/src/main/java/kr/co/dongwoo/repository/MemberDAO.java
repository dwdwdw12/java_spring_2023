package kr.co.dongwoo.repository;

import java.util.List;

import kr.co.dongwoo.vo.MemberVO;

public interface MemberDAO {

	MemberVO getMember(String memId);

	int updateMember(MemberVO vo);

	List<MemberVO> getAllMember();

	List<MemberVO> getMemberForEach(List<String> list);

	int insertMember(MemberVO vo);
	
}
