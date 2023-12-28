package kr.co.dongwoo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.dongwoo.vo.MemberVO;

@Repository("memberDAO")	/*("...")을 붙이면 별명으로 작동. <bean id="memberDAO", class="kr.co.dongwoo.MemberDAOImpl">과 같음*/
public class MemberDAOImpl implements MemberDAO {

	//Mybatis
	@Autowired
	private SqlSession session;
	
	@Override
	public List<MemberVO> getAllMember() {
		return session.selectList("memberNs.selectMemberAll");
	}

	@Override
	public MemberVO getOneMember(String memId) {	
		return session.selectOne("memberNs.selectMemberId", memId);
	}

	@Override
	public int addMember(MemberVO vo) {
		return session.insert("memberNs.insertMember", vo);
	}

	@Override
	public int delMember(String memId) {
		return session.delete("memberNs.deleteMember", memId);
					  /*update 사용가능*/
	}

	@Override
	public int updateMember(MemberVO vo) {
		return session.update("memberNs.updateMember", vo);
	}

}
