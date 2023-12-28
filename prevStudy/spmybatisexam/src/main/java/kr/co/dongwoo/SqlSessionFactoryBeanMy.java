package kr.co.dongwoo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component("sqlSession")
public class SqlSessionFactoryBeanMy {
	DataSource dataSource;
	String configLocation;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
//	@Autowired
//	@Value("abc")
	public void setMyConfigLocation(String configLocation) {
		this.configLocation = configLocation;
	}
	
}
