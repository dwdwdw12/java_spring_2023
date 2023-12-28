package com.dongwoo.user.dao;

public class DaoFactory {
	//필요한 객체를 생성해서 필요한 곳에 넣어주는 역할
	//new OracleConnection ()을 생성해서 
	//new  userDao()를 한 후에, UserDao 클래스에 넣어주었다(주입).
	
	//->applicationContext에 똑같이 써줌
//	public UserDao userDao() {
//		ConnectionInter connectioninter = new OracleConnection();
//		return new UserDao(connectioninter);
//	}
}
