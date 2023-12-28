package com.dongwoo.member.vo;

import lombok.Data;

@Data
public class MemberVO {
	private String memId;
	private String memPassword;
	private String memName;
	private String email;
	private String postCode;
	private String detailAddress;
	private String regiDate;
}
