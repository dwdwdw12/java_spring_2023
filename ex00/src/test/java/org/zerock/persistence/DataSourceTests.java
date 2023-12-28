package org.zerock.persistence;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.sample.SampleTests;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DataSourceTests {
	
	@Autowired				//root-context로부터 주입
	private DataSource dataSource;	
	
	@Test
	public void testConnection() {
		
		try {
			Connection conn = dataSource.getConnection();
			log.info("connection2 : " + conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		
	}
	
}
