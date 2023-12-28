package org.zerock.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleTxServiceImplTest {

	@Autowired
	private SampleTxServiceImpl serviceImpl;
	
	@Test
	public void test() {	//50~500자. 1개의 테이블에만 insert 작업이 수행됨.
							//@Transactional 사용시, 2개의 테이블에 모두 추가되거나, 모두 추가하지 않음.
		String str = "Spring의 핵심 개념 중 하나인 DI가 애플리케이션 모듈들 간의 결합도를 낮춘다면, AOP는 핵심 로직과 부가 기능을 분리하여 애플리케이션 전체에 걸쳐 사용되는 부가 기능을 모듈화하여 재사용할 수 있도록 지원하는 것 입니다. Aspect-Oriented Programming이란 단어를 번역하면 관점(관심) 지향 프로그래밍 이 됩니다. 프로젝트 구조를 바라보는 관점을 바꿔보자는 의미입니다.";
		String str2 = "aaaaa";
		log.info("length : " + str.getBytes().length);
		
		serviceImpl.addData(str);
	}

}
