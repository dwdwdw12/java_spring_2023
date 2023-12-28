package kr.co.dongwoo.repository;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.dongwoo.vo.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")	//설정정보가 들어있는 곳
public class MemberTest {
	
	@Autowired
	ApplicationContext context;
	
	@Autowired
	DataSource ds;
	
	@Autowired
	MemberDAO dao;
	
	@Test
	public void contextTest() {	//설정 정보를 잘 읽어왔는가 => 테스트의 첫출발
		assertNotNull(context);
		//스프링으로 등록된 빈 목록 보기
		for(String createBeanName : context.getBeanDefinitionNames()) {
			System.out.println("Bean 목록: "+createBeanName);	//root-context에 등록된 bean만 출력. 
			//root-context에 등록하려면 namespace 탭에서 context 체크. servlet-context에서 <context:component-scan base-package="kr.co.dongwoo" /> 붙여넣기
															//servlet-context에 등록된 bean은 안나옴
		}
	}
	
	@Test
	public void connectionTest() {	//DB 연결이 잘 되었는가
		assertNotNull(ds);
	}
	
	@Test
	public void getMemberTest() {	//bean 목록에 dao를 등록해야 작동가능
		assertNotNull(dao.getMember("333"));
		System.out.println("===getMemberTest 결과: "+dao.getMember("333"));	//commit 되지 않은 정보가 출력됨.
	}
	
	@Test
	public void forEachTest() {
		List<String> list = new ArrayList<String>();
		list.add("111"); list.add("222"); list.add("333");	//주석처리하면 동적쿼리의 조건을 만족하지 않음. where절이 사라지므로 select * from members가 된다.
		
		List<MemberVO> listResult = dao.getMemberForEach(list);
		assertNotNull(listResult);
		
		for(MemberVO vo:listResult) {
			System.out.println("list: "+vo);
		}
	}
	
	@Test
	public void insertMember(){
		MemberVO newmem = new MemberVO("abc","abc","abc","abc","abc","abc");
		assertNotNull(dao.insertMember(newmem));
	}
	
}
