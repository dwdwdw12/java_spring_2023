package org.zerock.mapper;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	
	@Autowired
	private ReplyMapper mapper;
	
	private Long[] bnoArr = {1000000L, 999999L,	999998L, 999997L, 999996L};
	
	@Test
	public void testMapper() {		//잘 동작하는지 확인
		log.info(">>>>>"+mapper);	
	}
	
	@Test
	public void testInsert() {
		IntStream.rangeClosed(1, 10).forEach(i->{		//rangeClsoed : 종료값을 포함. range : 종료값을 표현하지 않음.
			ReplyVO vo = ReplyVO.builder()
								.bno(bnoArr[i%5])
								.reply("댓글 테스트" + i)
								.replyer("댓글 작성자" + i)
								.build();
			mapper.insert(vo);
		});
	}
	
	@Test
	public void testRead() {
		log.info(mapper.read(1L));
	}
	
	@Test
	public void testDelete() {
		log.info(mapper.delete(10L));
	}
	
	@Test
	public void testUpdate() {
		ReplyVO vo = ReplyVO.builder()
						.rno(1L)
						.reply("댓글 업데이트")
//						.replyer("작성자 업데이트")
						.build();
		log.info(mapper.update(vo));
	}
	
	@Test
	public void testInsert2() {
		ReplyVO vo = ReplyVO.builder()
							.bno(1000000L)
							.reply("댓글 테스트5")
							.replyer("댓글 작성자5")
							.build();
		mapper.insert(vo);
	}
	
	@Test
	public void testGetListWithPaging() {
//		mapper.getListWithPaging(new Criteria(), 1000000L)
//				.forEach(list->log.info(list));
		mapper.getListWithPaging(new Criteria(2, 2), 1000000L)
		.forEach(reply->log.info(reply));
	}
	
	@Test
	public void testGetCountByBno() {
		int result = mapper.getCountByBno(1000000L);
		log.info("count : " + result);
	}
	
}
