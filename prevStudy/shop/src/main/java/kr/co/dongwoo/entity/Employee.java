package kr.co.dongwoo.entity;

import java.sql.Date;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "employee")
@Table(name = "employees")	//클래스의 이름과 실제 테이블의 이름이 다를 때, 사용하기.
@SequenceGenerator(
	name = "empSeq",
	sequenceName = "EMPLOYEES_SEQ", 
	initialValue = 300,
	allocationSize = 1)
@Getter @Setter @ToString 
@Builder		//builder를 사용하면 기본생성자가 생성되지 않음
@NoArgsConstructor @AllArgsConstructor //builder 사용시 필요
public class Employee { 

	@Id
	@Column(name = "EMPLOYEE_ID")	//필드명과 칼럼명이 다를 때 사용.
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empSeq")	//12버전 이하는 sequence. 
	private Integer employeeId;
	
	@Column(name = "FIRST_NAME")
	private String FIRSTNAME;
	
	@Column(name = "LAST_NAME")	//필요없음
	private String LASTNAME;	//lastName으로 입력하면 DB에서 last_name으로 인지함
	
	private String EMAIL;
	
	@Column(name = "PHONE_NUMBER")
	private String PHONENUMBER;
	
	@Column(name = "HIRE_DATE")
	private Date HIREDATE;
	
	@Column(name = "JOB_ID")
	private String JOBID;
	
	private Integer SALARY;
	
	@Column(name = "COMMISSION_PCT")
	private String COMMISSIONPCT;
	
	@Column(name = "MANAGER_ID")
	private Integer MANAGERID;
	
	@Column(name = "DEPARTMENT_ID")
	private Integer DEPARTMENTID;
	
	
	
	
}
