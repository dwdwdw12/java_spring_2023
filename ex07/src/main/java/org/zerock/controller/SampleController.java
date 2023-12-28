package org.zerock.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleVO;
import org.zerock.domain.Ticket;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/sample/")
@Log4j
public class SampleController {
												//Content-Type
	@GetMapping(value = "getText", produces = "text/plain; charset=utf-8")	
	public String getText() {
		log.info("MINE TYPE : " + MediaType.TEXT_PLAIN_VALUE);		//org.springframework.http.MediaType
		return "안녕하세요";			//값만 넘겨줌, Content-Type
	}
	
	//http://localhost:8081/sample/getSample.json 또는 .xml로 접속하여 타입을 바꿀 수 있음. 기본 json 방식
	@GetMapping(value = "/getSample", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public SampleVO getSample() {
		return new SampleVO(112, "스타", "로드");
	}
	
	@GetMapping("/getSample2")			//http://localhost:8081/sample/getSample2 접속시 기본으로 xml 방식
	public SampleVO getSample2() {		//http://localhost:8081/sample/getSample2.json 접속시 json 타입.
		return new SampleVO(113, "스타", "로드");
	}
	
	@GetMapping("/getList")
	public List<SampleVO> getList(){
		return IntStream.range(1, 10).mapToObj(i->new SampleVO(i, i+"First", i+"Last")).collect(Collectors.toList());
			//1부터 10까지의 숫자가 들어감													//수집하여 list로 만듦
	}
	
	@GetMapping("/getList2")
	public List<SampleVO> getList2(){
		List<SampleVO> list = new ArrayList<SampleVO>();
		
		for(int i=1;i<=10;i++) {
			SampleVO vo = new SampleVO(i, i+"First", i+"Last");
			list.add(vo);
		}
		
		return list;
	}
	
	@GetMapping("/getMap")
	public Map<String, SampleVO> getMap(){
		Map<String, SampleVO> map = new HashMap<String, SampleVO>();
		map.put("First", new SampleVO(111, "그루트", "주니어"));
		return map;
	}
	
	@GetMapping(value = "/check", params= {"height", "weight"})	//param을 반드시 전달해야 함. 생략한다면 아래에서 지정해주어야 함
	public ResponseEntity<SampleVO> check(Double height, Double weight){
		SampleVO vo = new SampleVO(0,""+height, ""+weight);
		
		ResponseEntity<SampleVO> result = null;
		
		//http://localhost:8081/sample/check.json?height=140&weight=50
		if(height<150) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		} else {
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		
		return result;
	}
	
	@GetMapping("/product/{cat}/{pid}")	//http://localhost:8081/sample/product/cat/1234.json
	public String[] getPath(@PathVariable("cat") String cat, @PathVariable("pid") String pid) {
										//"" 생략시 동작		//@생략시 null 값이 들어옴
		return new String[] {"category : " + cat, "productId : " + pid};
	}
	
	@PostMapping("/ticket")	//postman 사용하기. body>row>json 선택, {"tno" : 10, "owner" : "aaa", "grade" : "B"} 입력.
	public Ticket convert(@RequestBody Ticket ticket) {				//변수명, 타입이 일치하지 않으면 error
						//@생략시 null값 전송
		log.info("convert : "+ticket);
		return ticket;		//xml 방식으로 반환. .json을 붙여 json타입으로 확인 가능.
	}
	
}
