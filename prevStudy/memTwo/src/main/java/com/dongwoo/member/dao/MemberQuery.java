package com.dongwoo.member.dao;

public interface MemberQuery {
	String membersave = "insert into members values(?,?,?,?,?,?,sysdate)";
	String getMember = "select * from members where memId=?";
	String delMember = "delete from members";
	String listMember = "select * from members";
}
