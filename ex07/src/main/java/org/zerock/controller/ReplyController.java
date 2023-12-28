package org.zerock.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyPageDTO;
import org.zerock.domain.ReplyVO;
import org.zerock.service.ReplyService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@RequiredArgsConstructor
@RequestMapping("/replies")
public class ReplyController {

	private final ReplyService service;
	
	//postman으로 시험하기
	@PreAuthorize("isAuthenticated()")
	@PostMapping(value = "/new", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> create(@RequestBody ReplyVO vo){
		log.info("ReplyVO : " + vo);
		
		int insertCount = service.register(vo);
		
		return insertCount==1 ? new ResponseEntity<String>("success", HttpStatus.OK) 	//"success", 200, Ok
								: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR); //500, Interval Server Error
	}
	
	@GetMapping(value = "/pages/{bno}/{page}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ReplyPageDTO> getList(@PathVariable("bno") Long bno,
													@PathVariable("page") int page){	//bno에 해당하는 댓글 amount개 조회
		log.info("get List...bno : " + bno + " page : " +page);							//없으면 null값.
		
		Criteria cri = new Criteria(page, 10);
		
		return new ResponseEntity<ReplyPageDTO>(service.getListPage(cri, bno), HttpStatus.OK);	//데이터와 상태를 반환
	}
	
	@GetMapping(value = "/{rno}", produces = {MediaType.APPLICATION_JSON_VALUE})	//대부분 xml 타입이 아닌 json 타입 사용.
	public ResponseEntity<ReplyVO> get(@PathVariable("rno") Long rno){
		log.info("get : " + rno);
		return new ResponseEntity<ReplyVO>(service.get(rno), HttpStatus.OK);
	}
	
	@PreAuthorize("principal.username==#vo.replyer")
	@DeleteMapping(value = "/{rno}")
	public ResponseEntity<String> remove(@RequestBody ReplyVO vo, @PathVariable("rno") Long rno){		//뒤에건 json 타입으로 날아오니까
		log.info("delete : " + rno);
		log.info("replyer : " + vo.getReplyer());
		return service.remove(rno)==1? new ResponseEntity<String>("success", HttpStatus.OK) 
										: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PreAuthorize("principal.username==#vo.replyer")				//json으로 받겠다
	@RequestMapping(method = {RequestMethod.PATCH, RequestMethod.PUT}, value = "/{rno}", consumes = "application/json")
	public ResponseEntity<String> modify(@RequestBody ReplyVO vo, @PathVariable("rno") Long rno){
		log.info("modify >> " + rno);
		log.info("Reply VO >> " +vo);			//put : 칼럼 1개 수정. patch : 칼럼 여러개 수정
		
		//vo.setRno(rno);	//필요 없음?
		
		return service.modify(vo)==1? new ResponseEntity<String>("success", HttpStatus.OK) 
										: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
