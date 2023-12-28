package com.dongwoo.user;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.dongwoo.user.dao.UserDao;
import com.dongwoo.user.domain.User;

public class UserDaoTest {
	@Test
	public void addNget() {
		User user = new User();
		
		user.setId("user1");
		user.setName("user11");
		user.setPassword("user111");
		
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");	//resources의 xml파일의 이름과 똑같이 쓰기
		
		UserDao dao = context.getBean("userDao", UserDao.class);	// xml-bean의 id
		//UserDao dao = (UserDao) context.getBean("userDao");
		
		int result = dao.add(user);	

		System.out.println(user.getId() + " 등록 성공"); 
		
		User getUser = dao.get(user.getId());
		System.out.println(getUser.getName());
		System.out.println(getUser.getPassword());
		System.out.println(getUser.getId() + " 조회 성공");
	
	
	}
}
