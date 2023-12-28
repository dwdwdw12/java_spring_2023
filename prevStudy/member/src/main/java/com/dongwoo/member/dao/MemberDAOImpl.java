package com.dongwoo.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.dongwoo.member.domain.MemberVO;

public class MemberDAOImpl implements MemberDAO{
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {		//setter 생성
		this.jdbcTemplate = jdbcTemplate;					
	}
					//제네릭으로 vo객체 선언
	private RowMapper<MemberVO> mapper = new RowMapper<MemberVO>() {		//unimplemented
		//rowmapper 타입 변수 선언 후 익명클래스 생성 할당
		@Override
		public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			MemberVO vo = new MemberVO();
			vo.setDetailAddress(rs.getString("detailAddress"));
			vo.setEmail(rs.getString("email"));
			vo.setMemId(rs.getString("memId"));
			vo.setMemName(rs.getString("memName"));
			vo.setMemPassword(rs.getString("memPassword"));
			vo.setPostCode(rs.getString("postCode"));
			vo.setRegiDate(rs.getString("regiDate"));
			
			return vo;
		}
		
	};
	////////////////////////////여기까지 준비작업 
	
	@Override
	public int insertMember(MemberVO vo) {
		int result=0;
		result = jdbcTemplate.update("insert into members values(?,?,?,?,?,?,sysdate)"
				,vo.getMemId(),vo.getMemPassword(),vo.getMemName(),vo.getEmail()
				,vo.getPostCode(),vo.getDetailAddress());	//쿼리문 작성, 순서대로
		return result;
	}

	@Override
	public int deleteMember(String memId) {
		return jdbcTemplate.update("delete from members where memId = ?",memId);
	}

	@Override
	public int updateMember(MemberVO vo) {
		return jdbcTemplate.update("update members set memPassword = ?, memName = ?, email=? where memId=?"
				,vo.getMemPassword(), vo.getMemName(), vo.getEmail(), vo.getMemId());
	}
	
	@Override
	public int deleteAll() {
		return jdbcTemplate.update("delete from members");
	}
	//////////////////////////////////////////////////////////CRUD
	
	@Override
	public List<MemberVO> getAllMember() {
		List<MemberVO> list = null;
		//jdbcTemplate.query("쿼리문",?에 들어갈 자료, RowMapper 필드명);
		list=jdbcTemplate.query("select * from members", mapper);
		return list;
	}
	
	@Override      
	public MemberVO getMember(String memId) {
		return jdbcTemplate.queryForObject("select * from members where memId=?"
				, new Object[] {memId}, mapper);
		//?가 몇 개가 올 지 모르므로, object의 배열로 생성하여 둘째 칸에 넣기 
	}

	

	@Override
	public int getCount() {
		return jdbcTemplate.queryForObject("select count(*) from members", Integer.class);
	}																	  //wrapper class

	

}
