package com.dongwoo.member.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class BoardVO {
	private Long boardNo;	//long boardNo(기본타입)보다 Long boardNo(객체타입)를 더 권장한다.
	private String title;
	private String contents;
	private String writer;
	private String writeDate;
	public BoardVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardVO(long boardNo, String title, String contents, String writer, String writeDate) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
	}
	
	
}
