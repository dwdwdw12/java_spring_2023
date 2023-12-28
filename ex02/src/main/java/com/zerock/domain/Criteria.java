package com.zerock.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Criteria {

	private int pageNum;	// page, 1p, 2p, 3p...
	private int amount;		// page당 data 갯수
	
	private String type;	//Title, Content, Writer
	private String keyword; //검색 내용
	
	public Criteria() {
		this(1,10);
	}

	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	//type=TCW, keyword="서울"	=> String[] str = {"t", "c", "w"}
	public String[] getTypeArr() {
		return type==null? new String[] {} : type.split("");
	}
	
	public String getListLink() {
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
				.queryParam("pageNum", this.pageNum)
				.queryParam("amount", this.getAmount())
				.queryParam("type", this.getType())
				.queryParam("keyword", this.getKeyword());
				
		return builder.toUriString();
	}
	
}
