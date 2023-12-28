package org.zerock.controller;

import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")	// 기본 접속 주소
@Log4j
//@RestController					//return 타입을 String으로 바꾸어야 함.  //페이지를 찾아가지 않음. 화면에 바로 응답.
public class SampleController {		//서블릿에 비해 단순한 구조 - 장점
	
	@RequestMapping("")
	public void basic2() {		//~~~/sample/ 접속 -> basic() 실행
		log.info("basic...");
	}
	
	//@RequestMapping(value = "/basic", method = RequestMethod.GET)	//응답방식별로 다른 동작을 지정할 수 있다(postman으로 확인해보기)
	@GetMapping(value = "/basic")
	public void basic() {
		log.info("basic_get...");
	}

//	@RequestMapping(value = "/basic", method = RequestMethod.POST)
	@PostMapping("/basic")
	public void basic3() {
		log.info("basic_post...");
	}
	
	@PostMapping("/basic2")
	public String restbasic3() {
		log.info("basic_post...");
		return "basic_post";	//@RestController -> 값만 전달함. json 타입으로 객체를 주고 받을 수 있음. 
								//@Controller -> jsp 파일을 찾아서 보여줌
	}

//	@RequestMapping(value = "/basic", method = RequestMethod.DELETE)
	@DeleteMapping("/basic")
	public void basic4() {
		log.info("basic_delete...");
	}
	
	@RequestMapping("aaa")		//기본 주소에 덧붙임.
	public void aaa() {		//~~~/sample/aaa 접속 -> aaa() 실행
		log.info("aaa...");
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	@GetMapping("/ex01")	//http://localhost:8081/sample/ex01?name=kim&age=22
	public String ex01(SampleDTO dto, Model model) {	//타입이 일치하면 자동으로 매핑. 불일치하면 초기값.
		log.info("dto : " + dto);
		log.info("name : " + dto.getName());
		log.info("age : " + (dto.getAge()+10));	//원래는 String. 자동으로 형변환 하여 10을 더함
		model.addAttribute("dto", dto);
		return "ex01";
	}
	
	@GetMapping("/ex02")
//	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {	//하나씩 받음. 이름이 다른 경우에 사용. 
	public String ex02(String name, int age) {	//@RequestParam() 없어도 동작 가능. 이름이 같은 경우에만. 보통은 붙이지 않음.
		log.info("==> " + name);	//name
		log.info("==> " + age);	//age에 dto 없이 변수에 담아줌
		return "ex02";
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@GetMapping("/ex02Bean")	//http://localhost:8081/sample/ex02Bean?list[0].name=aaa&list[2].name=bbb -> [] 인식 못한다면 따로 처리(p135)
	public String ex02Bean(SampleDTOList list) {
		log.info("list : " + list);
		return "ex02Bean";
	}
	
	@GetMapping("/ex04")	//http://localhost:8081/sample/ex04?name=kim&age=22&page=11
	public String ex04(SampleDTO dto, int page, Model model) {	//객체는 전달되지만, 기본 자료형은 전달되지 않음. 
		log.info(dto);											//기본 자료형은 model에 담아서 전달하기
		log.info(page);
		model.addAttribute("page", page);
		return "sample/ex04";
	}
	
	@GetMapping("/ex05")	//http://localhost:8081/sample/ex05?name=kim&age=22
	public String ex05(String name, int age, RedirectAttributes rttr) {
		log.info(name);
		log.info(age);
		
		rttr.addAttribute("name", name);
		rttr.addAttribute("age", age);
		
		rttr.addAttribute("name2", name);
		rttr.addAttribute("age2", age);
		
		return "ex05";
	}
	
	@GetMapping("/ex06/{name}/{age}")	//http://localhost:8081/sample/ex06/aaa/30			//순서대로 받아줌
	public String ex06(@PathVariable("name") String name, @PathVariable("age") int age) {
		log.info("name : " + name);
		log.info("age : " + age);
		
		return "ex06";
	}
	
	@DeleteMapping("/ex07/{id}")	//id 값을 바로 가져가서 sql 작업에 활용
	public String ex07(@PathVariable("id") int id) {
		//삭제 작업.
		return "ex07";
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@GetMapping("/ex08")
	public @ResponseBody SampleDTO ex08() {		//반환타입을 VO나 DTO로 줄 경우, JSON 타입으로 주고받을 목적으로 사용. 넘겨줄 때 @ResponseBody 필요.
		log.info("ex08...");														//@RestController=@Controller+@ResponseBody
		SampleDTO dto = new SampleDTO();
		dto.setName("조조");
		dto.setAge(20);
		return dto;								//화면상에 { "name": "조조", "age": 20 } 가 출력.
	}
	
	@GetMapping("/ex09")
	public void ex09(@RequestBody SampleDTO dto) {	// JSON 타입을 넘겨받을 경우, @RequestBody 사용.
		log.info("ex09...");														
		log.info(dto.getName());														
		log.info(dto.getAge());														
	}
	
	@GetMapping("/ex10")
	public ResponseEntity<String> ex10(){		//결과값 + 상태 코드값을 확인할 수 있음
		log.info("ex10...");
		String msg = "{\"name\" : \"홍길동\"}";	//{ "name": "홍길동"}
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=utf-8");
	
		return new ResponseEntity<String>(msg, header, HttpStatus.OK);	
			//상태 코드 값 = 200(f12>네트워크>상태 참고). HttpStatus의 조건(OK, ACCEPTED, ...)에 따라 달라짐
	}
	
	@GetMapping("/exUpload")
	public void exUpload() {
		log.info("/exUpload...");
	}
	
	@PostMapping("/exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) {
		files.forEach(file -> {
			log.info("------------------------");
			log.info("name : " + file.getOriginalFilename());
			log.info("size : " + file.getSize());
		});
	}
	
}
