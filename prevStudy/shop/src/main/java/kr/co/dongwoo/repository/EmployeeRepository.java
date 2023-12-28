package kr.co.dongwoo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import kr.co.dongwoo.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	
	public String query2 = new Test().query();	//안됨
	
	public List<Employee> findByFIRSTNAME(String name);
	public List<Employee> findByEMAIL(String email);
	public List<Employee> findByFIRSTNAMELikeOrFIRSTNAMELike(String lowerChar, String upper);
	public List<Employee> findByFIRSTNAMELikeOrFIRSTNAMELikeOrderByEmployeeIdDesc(String lowerChar, String upper);
	public List<Employee> findByFIRSTNAMEContainingOrFIRSTNAMEContaining(String str1, String str2);
	public List<Employee> findByFIRSTNAMEContaining(String str);
	
															//'%?1%' 불가능
	@Query(/*query2*/"select em from employee em where em.FIRSTNAME like %?1%")	//테이블명(Employees)가 아닌 엔터티명(employee, @Entity(name = "employee"), 따로 이름을 지정해주지 않으면 클래스명으로)을 사용
	public List<Employee> findByABC(String likeData);
	
	@Query(query1)	//@Param 굳이 필요없음. 이름이 다르거나 변수의 이름을 끝까지 전달하고 싶을 때.
	public List<Employee> findByFirstParam(String likeStr, String likeStr2);
	
	String query1 = "select em from employee em where em.FIRSTNAME like %:likeStr2% and em.FIRSTNAME like %:likeStr%";
	
}
