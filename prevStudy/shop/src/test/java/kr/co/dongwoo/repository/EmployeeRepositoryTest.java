package kr.co.dongwoo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import kr.co.dongwoo.entity.Employee;

@SpringBootTest
@TestPropertySource(locations = {"classpath:application.properties"})
public class EmployeeRepositoryTest {
	
	@Autowired
	EmployeeRepository repository;
	
	@Test
	public void repositoryTest(){
		assertNotNull(repository);
	}
	
	@Test
	@DisplayName("직원 인원 카운트 테스트")
	public void countTest() {
		assertEquals(107, repository.count());	//count()는 long형 반환, 에러나면 L 붙이기
	}
	
	@Test
	@DisplayName("직원 Steven 조회 테스트")
	public void findByIdTest() {
		Employee emp = repository.findById(100).get();	//반환되는 타입이 Optional<>이라면 get()을 붙여주기. 또는 형변환하기
		System.out.println("==================================");
		System.out.println(emp);
		System.out.println("==================================");
	}
	
	@Test
	@DisplayName("전체 직원 조회 테스트")
	public void findAllTest() {
		List<Employee> employees = (List<Employee>) repository.findAll();
		System.out.println("=========향상된 for문 활용============");
		for(Employee emp: employees) {
			System.out.println(emp.toString());
		}
		System.out.println("===========forEach활용=============");
		employees.forEach( (emp) -> System.out.println(emp)); //employees.forEach( (emp) -> {System.out.println(emp);});
	
	}
	
	@Test
	public void saveDeleteTest() {
		/*insert*/
//		Employee emp = Employee.builder().
//				DEPARTMENTID(90)
//				.EMAIL("userone")
//				.JOBID("AD_PRES")
//				.FIRSTNAME("user")
//				.LASTNAME("one")
//				.SALARY(15000)
//				.COMMISSIONPCT(null)
//				.MANAGERID(101)
//				.PHONENUMBER("0000110112")
//				.HIREDATE(new java.sql.Date(new java.util.Date().getTime()))
//				.build();
//		Employee saveResult = repository.save(emp);
//		System.out.println("저장하고 반환된 값: " + saveResult);
		
		//Employee emp2 = new Employee();	//같은 내용
		//emp2.setDEPARTMENT_ID(90);	//일일히 설정하기
		
		/*Select*/
		Employee getSaveEmployee = repository.findById(213/*saveResult.getEmployeeId()*/).get();
		System.out.println("저장된 데이터: " + getSaveEmployee);
		
//		/*Update*/ 
//		getSaveEmployee.setEMAIL("usertwo");
//		getSaveEmployee.setPHONENUMBER("1112223333");
//		repository.save(getSaveEmployee);
		
		/*Delete*/
//		repository.deleteById(getSaveEmployee.getEmployeeId());
		
	}
	
	@Test
	public void userDefineQueryMethodTest() {
		List<Employee> result = repository.findByFIRSTNAME("Lisa");
		if(result!=null) {
			System.out.println(result.get(0));
		} else {
			System.out.println("조건에 맞는 데이터가 발견되지 않았습니다.");
			//필요한 처리 작업을 해주면 된다.
		}
			
	}
	
	@Test
	public void userDefineQueryTest() {
		List<Employee> result = repository.findByFIRSTNAMELikeOrFIRSTNAMELike("%a%","%A%");
		for(int i=0;i<result.size();i=i+1) {
			System.out.println(result.get(i));
		}	
	}
	
	@Test
	public void userDefineQueryTest2() {
		List<Employee> result = repository.findByFIRSTNAMELikeOrFIRSTNAMELikeOrderByEmployeeIdDesc("%a%","%A%");
		for(int i=0;i<result.size();i=i+1) {
			System.out.println(result.get(i));
		}	
	}
	
	@Test
	public void userDefineQueryTest3() {
		List<Employee> result = repository.findByFIRSTNAMEContainingOrFIRSTNAMEContaining("a","A");
		for(int i=0;i<result.size();i=i+1) {
			System.out.println(result.get(i));
		}	
	}
	
	@Test
	public void userDefineQueryTest11() {
		List<Employee> result = repository.findByABC("A");
		for(int i=0;i<result.size();i=i+1) {
			System.out.println(result.get(i));
		}	
	}
	
	@Test
	public void userDefineQueryTest12() {
		List<Employee> result = repository.findByFirstParam("A","l");
		for(int i=0;i<result.size();i=i+1) {
			System.out.println(result.get(i));
		}	
	}
}
