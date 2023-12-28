package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class PageDTO {
	
	private int startPage;
	private int endPage;
	private boolean prev, next;
	
	private int total;
	private Criteria cri;
	
	//						(1,10)	  125
	public PageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		this.endPage = (int)(Math.ceil(cri.getPageNum()/10.0))*10;		//10페이지씩 표시할 경우, 마지막 페이지
		this.startPage = this.endPage-9;
		
		int realEnd = (int)(Math.ceil((total*1.0)/cri.getAmount()));	//실제 끝 페이지.
		
		if(realEnd < endPage) {
			endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;			//1보다 큰 페이지면 true. 1페이지면 false, prev가 표시되지 않을 예정.
		this.next = this.endPage < realEnd;		//실제 끝 페이지보다 작으면 true. 마지막 페이지라면 false, next가 표시되지 않음
		
	}
	
}
