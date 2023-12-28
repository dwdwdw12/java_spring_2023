package kr.co.dongwoo.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.dongwoo.vo.MemberVO;

@Repository
public class MemberDAOMybatis implements MemberDAO{
	
	@Autowired
	SqlSession session;
	
	String ns =  "kr.co.dongwoo.member.";	//오타로 인한 오류를 줄이기 위해
	
	@Override
	public MemberVO getMember(String memId) {
		return session.selectOne(ns+"getMember",memId);
	}
	
	public MemberVO getMember(String startNum, String endNum) {	//2개를 받을경우
		Map<String, String> map = new HashMap<String, String>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		return session.selectOne(ns+"getMemberMap", map);	//map을 사용
	}
	
	@Override
	public int updateMember(MemberVO vo) {
		return session.update(ns+"updateMember", vo);
	}
	
	@Override
	public List<MemberVO> getAllMember(){
		return session.selectList(ns+"getAllMember");
	}

	@Override
	public List<MemberVO> getMemberForEach(List<String> list) {
	
		return session.selectList(ns+"getMemberForEach", list);
	}
	
	@Override
	public int insertMember(MemberVO vo) {
		return session.insert(ns+"insertMember", vo);
	}
	
}
