package com.ezen.mybatis.project;

import lombok.Data;

/*create table mybatis(
    id number(5) primary key,
    name varchar2(20),
    phone varchar2(20),
    address varchar2(50)
);*/

@Data
public class MemberVO {
	private int id;
	private String name;
	private String phone;
	private String address;
}
