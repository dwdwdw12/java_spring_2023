package com.zerock.controller;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml"
						,"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})	//controller에 대한 정보는 servlet-context가 가지고 있음
@Log4j
@WebAppConfiguration	//웹환경 테스트
public class BoardControllerTests {
	
	@Autowired
	private WebApplicationContext context;	//웹환경 테스트. 서버를 구동하지 않고 테스트
	
	private MockMvc mockMvc;	//가상서버
	
	@Before			//사전 동작
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testList() throws Exception{
		log.info(
			mockMvc.perform(							
					MockMvcRequestBuilders.get("/board/list"))	//요청
					.andReturn()								//반환
					.getModelAndView()							//model과 view를 함께 반환
					.getModelMap()								//view 대신 값만 취해서 검토하겠다
		);
	}
	
	@Test
	public void testRegister() throws Exception{
/*		log.info(
			mockMvc.perform(							
					MockMvcRequestBuilders.post("/board/register")
						.param("title", "mock title")
						.param("content", "mock content")
						.param("writer", "mock writer"))	
					.andReturn()								
					.getModelAndView()							
					.getModelMap()								
		);
*/		
		//BoardVO에서 @Builder 아래에 @NoArgsConstructor 또는 @AllArgsConstructor 추가해야 함(mockMvc와 충돌).
		String resultPage = mockMvc.perform(							
								MockMvcRequestBuilders.post("/board/register")
								.param("title", "mock title")
								.param("content", "mock content")
								.param("writer", "mock writer"))	
							.andReturn()								
							.getModelAndView()							
							.getViewName();
			
		log.info("view name : " + resultPage);
	}
	
	@Test
	public void testGet() throws Exception{
		log.info(
				mockMvc.perform(MockMvcRequestBuilders.get("/board/get").param("bno", "1"))		//1L이 아니라 "1" 사용하기
						.andReturn()								
						.getModelAndView()							
						.getModelMap()								
			);
	}
	
	@Test
	public void testModify() throws Exception{

		String resultPage = mockMvc.perform(							
								MockMvcRequestBuilders.post("/board/modify")
								.param("title", "modify title")
								.param("content", "modify content")
								.param("writer", "modify writer")
								.param("bno", "15"))	
							.andReturn()								
							.getModelAndView()							
							.getViewName();
			
		log.info("view name : " + resultPage);
	}
	
	@Test
	public void testRemove() throws Exception{

		String resultPage = mockMvc.perform(							
								MockMvcRequestBuilders.post("/board/remove")
								.param("bno", "16"))	
							.andReturn()								
							.getModelAndView()							
							.getViewName();
			
		log.info("view name : " + resultPage);
	}
	
}
