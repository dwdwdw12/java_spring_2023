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

import com.dongwoo.member.domain.MemberVO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//Spring에서 테스트를 할 경우, 아래의 두 어노테이션 사용	//토비의 스프링 187p
@RunWith(SpringJUnit4ClassRunner.class)	//JUnit과 Spring을 이용한 test.
@ContextConfiguration(locations="/bean.xml")	//경로 지정시 대소문자 구분하기, src/main/resources에 bean.xml 파일 생성하기(이름은 상관없음.)
public class MemberDAOTest {
	@Autowired
	private ApplicationContext context;	//필드 => 생성되면 기본값을 갖는다. context=null;
	
	@Autowired
	private MemberDAO dao;			//폴더가 같아서 import 하지 않아도 괜찮음
	
	private MemberVO mem1, mem2, mem3;
	
	@Test
	@Ignore
	public void contextTest() {
		assertNotNull(context);	//@autowired가 context에 임의의 값을 추가. not null이 됨.
		
	}
	
	@Before
	public void dataSetup() {
		//mem1 = new MemberVO("아이디","패스워드","이름","메일","우편번호","상세주소",null);	//regidate는 일단 null
		mem1 = new MemberVO("id1","pw1","name1","aaa@aaa.com","12345","수원시",null);	//memberVO에서 @NoArgsConstructor, @AllArgsConstructor 생성
		mem2 = new MemberVO("id2","pw2","name2","bbb@bbb.com","23456","성남시",null);
		mem3 = new MemberVO("id3","pw3","name3","ccc@ccc.com","34567","남양주시",null);
	}
	
	@Test
	public void addNget() {						// 적어도 3번은 테스트해보기
//		System.out.println(dao);
//		assertNotNull(dao);			//dao에 데이터가 있는지 확인
		dao.deleteAll();
		assertEquals(dao.getCount(), 0);	//dao의 모든 데이터가 삭제되었는지
		
		int result = dao.insertMember(mem1);	//1개 입력시 1을 반환
		assertEquals(result, 1);
		assertEquals(dao.getCount(), 1);
		
		result = dao.insertMember(mem2);	
		assertEquals(result, 1);
		assertEquals(dao.getCount(), 2);
		
		result = dao.insertMember(mem3);	
		assertEquals(result, 1);
		assertEquals(dao.getCount(), 3);
		
		//정확하게 해당 칼럼에 입력이 되었는지 테스트해야 한다.	갯수만 확인하면, 입력순서가 올바른지 확인할 수 없음.
		MemberVO getVO = dao.getMember(mem1.getMemId());
		objEquals(mem1, getVO);
		getVO = dao.getMember(mem2.getMemId());
		objEquals(mem2, getVO);
		getVO = dao.getMember(mem3.getMemId());
		objEquals(mem3, getVO);
		
		
	}
	
	private void objEquals(MemberVO mem1, MemberVO getVO) {
		assertEquals(getVO.getDetailAddress(), mem1.getDetailAddress());
		assertEquals(getVO.getEmail(), mem1.getEmail());
		assertEquals(getVO.getMemName(), mem1.getMemName());
		assertEquals(getVO.getMemPassword(), mem1.getMemPassword());
		assertEquals(getVO.getPostCode(), mem1.getPostCode());
	}

}
