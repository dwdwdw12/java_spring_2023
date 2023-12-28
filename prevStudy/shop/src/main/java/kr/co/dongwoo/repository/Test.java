package kr.co.dongwoo.repository;

public class Test {

	String query() {
		return "select em from employee em where em.FIRSTNAME like %?1%";
	}

}
