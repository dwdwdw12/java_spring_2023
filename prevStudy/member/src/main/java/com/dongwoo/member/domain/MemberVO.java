package com.dongwoo.member.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor		//기본 생성자를 만들어라.
@AllArgsConstructor		//전체 값을 집어넣을 수 있는 생성자를 만들어라.
public class MemberVO {
	 private String memId;
	 private String memPassword;
	 private String memName;
	 private String email;
	 private String postCode;
	 private String detailAddress;
	 private String regiDate ;
}
