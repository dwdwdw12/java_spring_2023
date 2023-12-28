package com.dongwoo.member.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dongwoo.member.domain.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)	
@ContextConfiguration(locations="/bean.xml")
public class BoardDAOTest {
	
	@Autowired
	private ApplicationContext context;	
	
	@Autowired
	private BoardDAO dao;

	private BoardVO data1, data2, data3, data4;

	@Before
	public void setData() {
		data1 = new BoardVO(1L, "test title1","test contents1","writer1",null);
		data2 = new BoardVO(2L, "test title2","test contents2","writer2",null);
		data3 = new BoardVO(3L, "test title3","test contents3","writer3",null);
		dao.delAll();
	}

	@Test
	@Ignore
	public void objInjection() {
		assertNotNull(dao);			//bean에서 주입해야 함
	}
	
	@Test
	public void saveBoardTest() {
		int result = dao.saveBoard(data1);
		assertEquals(result, 1);
		assertEquals(dao.getCount(), 1);
		
		result=dao.saveBoard(data2);
		assertEquals(result, 1);
		assertEquals(dao.getCount(), 2);
		
		result=dao.saveBoard(data3);
		assertEquals(result, 1);
		assertEquals(dao.getCount(), 3);
		
		BoardVO getVO = dao.getBoard(data1.getBoardNo());
		objEquals(data1, getVO);
		getVO = dao.getBoard(data2.getBoardNo());
		objEquals(data2, getVO);
		getVO = dao.getBoard(data3.getBoardNo());
		objEquals(data3, getVO);
		
		
	}
	
	private void objEquals(BoardVO inData, BoardVO getData) {
		assertEquals(inData.getTitle(), getData.getTitle());
		assertEquals(inData.getContents(), getData.getContents());
		assertEquals(inData.getWriter(), getData.getWriter());
	}

}
