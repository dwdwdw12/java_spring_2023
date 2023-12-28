package org.zerock.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.zerock.domain.Ticket;

import com.google.gson.Gson;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml"
						,"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})	
@Log4j
@WebAppConfiguration
public class SampleControllerTest {

	@Autowired
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testConvert() throws Exception{
		Ticket ticket = new Ticket();
		ticket.setTno(123);
		ticket.setOwner("Admin");
		ticket.setGrade("A등급");
		
		String jsonStr = new Gson().toJson(ticket);	//Gson 라이브러리 : 자바 객체를 JSON 문자열로 변환하기 위해 사용.
													//MockMvc는 contentType을 이용해 전달하는 데이터가 무엇인지 알려줄 수 있으므로
		log.info(">>>>>>>"+jsonStr);
		
		mockMvc.perform(post("/sample/ticket")
					.contentType(MediaType.APPLICATION_JSON_VALUE)
					.content(jsonStr))
					.andExpect(status().is(200));
	}
	

}
