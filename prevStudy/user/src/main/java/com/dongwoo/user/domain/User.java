package com.dongwoo.user.domain;

import lombok.AllArgsConstructor;
import lombok.Data;	//getter setter, equals, tostring 등등 생성
import lombok.NoArgsConstructor;

@Data						//기본생성자만
@AllArgsConstructor			//전체생성자
@NoArgsConstructor			//기본생성자+전체생성자
public class User {
	private String id;
	private String name;
	private String password;
	
}
