package org.zerock.service;

import org.junit.Test; 
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceImplTests {
	
	@Autowired
	private BoardService boardService;
	
	@Test
	public void testRegister() {
		BoardVO board = BoardVO.builder()
								.title("service test")
								.content("service content")
								.writer("service writer")
								.build();
		boardService.register(board);
	}
	
	@Test
	public void testGetList() {
		Criteria criteria = new Criteria();
		boardService.getList(criteria).forEach(board -> log.info(board));;
	}
	
	@Test
	public void testGet() {
		BoardVO boardVO = boardService.get(1L);
		log.info(boardVO);
	}
	
	@Test
	public void testModify() {
		BoardVO board = BoardVO.builder()
				.bno(100L)
				.title("modify test")
				.content("modify content")
				.writer("modify writer")
				.build();
		log.info("isModify : " + boardService.modify(board));
	}
	
	@Test
	public void testDelete() {
		log.info("isRemove : " + boardService.remove(13L));
	}
	
}
