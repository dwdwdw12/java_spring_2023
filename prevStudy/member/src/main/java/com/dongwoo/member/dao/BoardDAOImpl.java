package com.dongwoo.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.dongwoo.member.domain.BoardVO;

import lombok.Setter;

//@Repository		//목적에 따라 어노테이션을 다르게. xml에도 bean으로 등록되어 있으므로 error 발생		
public class BoardDAOImpl implements BoardDAO {

	@Setter
	JdbcTemplate jdbcTemplate;
	
	RowMapper<BoardVO> mapper = new RowMapper<BoardVO>() {
		
		@Override
		public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			BoardVO vo = new BoardVO();
			vo.setBoardNo(rs.getLong("boardNo"));	//칼럼의 순서를 쓸 수도 있지만, 알아보기 불편하므로, 칼럼의 이름으로 작성하기를 권장
			vo.setTitle(rs.getString("title"));
			vo.setContents(rs.getString("contents"));
			vo.setWriter(rs.getString("writer"));
			vo.setWriteDate(rs.getString("writeDate"));
			return vo;
		}
	};

	@Override
	public int saveBoard(BoardVO vo) {
		return jdbcTemplate.update("insert into boards values(?,?,?,?,sysdate)",
				vo.getBoardNo(),vo.getTitle(),vo.getContents(),vo.getWriter());
	}

	@Override
	public int removeBoard(long boardNo) {
		return jdbcTemplate.update("delete from boards where boardNo = ?",boardNo);
	}

	@Override
	public int updateBoard(BoardVO vo) {
		return jdbcTemplate.update("update boards set title = ?, contents = ?, writer=? where boardNo=?"
				,vo.getTitle(), vo.getContents(), vo.getWriter(), vo.getBoardNo());
	}

	@Override
	public int getCount() {
		return jdbcTemplate.queryForObject("select count(*) from boards", Integer.class);
	}

	@Override
	public BoardVO getBoard(long boardNo) {
		return jdbcTemplate.queryForObject("select * from boards where boardNo=?"
				, new Object[] {boardNo}, mapper);
	}

	@Override
	public List<BoardVO> getAll() {
		return jdbcTemplate.query("select * from boards", mapper);
	}

	@Override
	public int delAll() {
		return jdbcTemplate.update("delete from boards");
		
	}
	

}
