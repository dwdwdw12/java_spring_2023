package com.zerock.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zerock.domain.BoardVO;
import com.zerock.domain.Criteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		
//		List<BoardVO> list = mapper.getList();
//		
//		for(BoardVO vo : list) {
//			log.info(vo);
//		}
		
		mapper.getList().forEach(board->log.info(board));
	}
	
	@Test
	public void testInsert() {
		BoardVO vo = BoardVO.builder()
							.title("builder title")
							.content("builder content")
							.writer("builder writer")
							.build();
		
//		BoardVO vo = new BoardVO();
//		vo.setTitle("insert test");
//		vo.setContent("insert content");
//		vo.setWriter("test user");
//		
		mapper.insert(vo);
	}
	
	@Test
	public void testInsertSelectKey() {	// bno를 콘솔창에서 확인할 수 있음
		BoardVO vo = BoardVO.builder()
							.title("builder title2")
							.content("builder content2")
							.writer("builder writer2")
							.build();
		
		mapper.insertSelectKey(vo);
	}
	
	@Test
	public void testRead() {
		BoardVO vo = mapper.read(3L);	//long 타입이므로
		log.info("BoardVO : "+vo);
	}

	@Test
	public void testDelete() {
		mapper.delete(9L);	//long 타입이므로
	}
	
	@Test
	public void testUpdate() {
		BoardVO vo = BoardVO.builder()
							.bno(5L)
							.title("update title")
							.content("update content")
							.writer("update writer")
							.build();
		int result = mapper.update(vo);
		log.info("update result : " + result);
	}
	
	@Test
	public void testGetListWithPagging() {
		
		Criteria cri = new Criteria();
		cri.setPageNum(3);
		cri.setAmount(20);
		
		List<BoardVO> list = mapper.getListWithPagging(cri);
		
		list.forEach(board->log.info(board));
		
	}
	
	@Test
	public void testGetTotalCount() {
		Criteria cri = new Criteria();
		
		cri.setType("TWC");
		cri.setKeyword("한글");
		int result = mapper.getTotalCount(cri);
		
		log.info(result);
	}
	
	@Test
	public void testSearch() {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("T", "한글2");
		map.put("C", "ㄴㄴ");
		map.put("W", "한글3");
		
		Map<String, Map<String, String>> outer = new HashMap<String, Map<String, String>>();
		
		outer.put("map", map);
		
		List<BoardVO> list = mapper.searchTest(outer);
		log.info(list);
	}
	
	@Test
	public void testSearchPaging() {			//test 충분히 하기(조건 모두 제거, 올바른 조건, 엉뚱한 조건)
		Criteria cri = new Criteria();
		cri.setType("TWC");
		cri.setKeyword("한글");
		
//		List<BoardVO> list = mapper.getListWithPagging(cri);
//		log.info(list);
		
		mapper.getListWithPagging(cri).forEach(list->log.info(list));
	}
	
}
