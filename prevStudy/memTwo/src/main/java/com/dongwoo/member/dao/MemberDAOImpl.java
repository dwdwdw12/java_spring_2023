package com.dongwoo.member.dao;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.dongwoo.member.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;	//jdbc에게 일을 시킬 거니까
	RowMapper<MemberVO> mapper = new RowMapper<MemberVO>() {

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
	
	@Override
	public int membersave(MemberVO vo) {
		//String query = "insert into members values(?,?,?,?,?,?,sysdate)";
		return this.jdbcTemplate.update(MemberQuery.membersave, vo.getMemId(), vo.getMemPassword(), vo.getMemName(),
				vo.getEmail(), vo.getPostCode(), vo.getDetailAddress());
	}

	@Override
	public MemberVO getMember(String memId) {
		//String query = "select * from members where memId=?";		//인터페이스에 상수로 정의하여 활용하는 방식
		return jdbcTemplate.queryForObject(MemberQuery.getMember, new Object[] {memId}, mapper);
	}

	@Override
	public int delMember() {
		return jdbcTemplate.update(MemberQuery.delMember);
	}

	@Override
	public List<MemberVO> listMember() {
		
		return jdbcTemplate.query(MemberQuery.listMember, mapper);
	}

}
