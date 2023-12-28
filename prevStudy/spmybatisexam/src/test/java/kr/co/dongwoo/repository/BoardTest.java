package kr.co.dongwoo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.dongwoo.vo.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardTest {
	
	@Autowired
	ApplicationContext context;
	
	@Autowired
	DataSource ds;
	
	@Autowired
	BoardDAO dao;
	
	@Test
	@Ignore
	public void contextTest() {
		assertNotNull(context);
		for(String createBeanName : context.getBeanDefinitionNames()) {
			System.out.println("Bean 목록: "+createBeanName);	//root-context에 등록된 bean만 출력. 
			//root-context에 등록하려면 namespace 탭에서 context 체크. servlet-context에서 <context:component-scan base-package="kr.co.dongwoo" /> 붙여넣기
															//servlet-context에 등록된 bean은 안나옴
		}
	}
	
	@Test
	@Ignore
	public void connectionTest() {
		assertNotNull(ds);
	} 
	
	@Test
	public void boardCountTest() {
		assertNotNull(dao.boardCount());
		System.out.println("board count : "+dao.boardCount());
	}
	
	@Test
	public void maxNumTest() {
		assertNotNull(dao.maxNum());
		System.out.println("maximum number : "+dao.maxNum());
	}
	
	@Test
	public void boardDetailTest() {
		assertNotNull(dao.boardDetail(1));
		System.out.println(dao.boardDetail(1));
	}
	
	@Test
	public void boardAddTest() {
		BoardVO newVO = new BoardVO(21,"20","20","20","20",13);
		assertEquals(dao.boardAdd(newVO),1);
	}
	
	@Test
	public void boardDeleteTest() {
		int result = dao.boardDelete(21);
		assertEquals(result, 1);
	}
	
	@Test
	public void boardModifyTest() {
		BoardVO modVO = new BoardVO(21,"mod","mod");
		assertEquals(dao.boardModify(modVO), 1);
	}
	
	//seqModify, boardReply
	@Test
	public void readCountTest() {
		assertEquals(dao.readCount(10), 1);
	}
	
	@Test
	public void boardListTest() {
		List<BoardVO> list = dao.boardList(6, 15);
		assertNotNull(list);
		for(BoardVO vo : list) {
			System.out.println("글 목록"+vo);
		}
	}
	
	@Test
	public void seqModifyTest() {
		BoardVO vo = new BoardVO(12,3);
		assertNotNull(dao.seqModify(vo)); 
	}
	
	@Test
	public void boardReplyTest() {
		BoardVO repvo = new BoardVO(21,"bb","bb","bb","bb",13,1,1,0);
		assertEquals(dao.boardReply(repvo), 1);
	}
	
//	@Test
//	public void boardPasswordTest() {
//		assertNotNull(dao.boardPassword(12));
//		System.out.println(dao.boardPassword(12));
//	}
	
}
