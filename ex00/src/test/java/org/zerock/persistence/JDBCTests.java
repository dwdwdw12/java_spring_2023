package org.zerock.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {

	static {						//객체 생성 이전에 static으로 올리겠다.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
//		Connection conn = null;
		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(					
											"jdbc:oracle:thin:@localhost:1521:xe",
											"book_ex",
											"book_ex");		//자원을 쓰고 자동으로 반납
			log.info("connection : " + conn);
		} catch (Exception e) {
			e.printStackTrace();
		} 
//		finally {
//			try {
//				if(conn!=null)
//				conn.close();
//			} catch (SQLException e) {					
//				e.printStackTrace();
//			}
//		}
		
	}
	
}
