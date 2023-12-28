package com.zerock.controller;

import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zerock.domain.BoardVO;
import com.zerock.domain.Criteria;
import com.zerock.domain.PageDTO;
import com.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller	//servlet-context.xml에 등록되어 있는지 확인
@RequestMapping("/board/*")
@Log4j
@RequiredArgsConstructor	//또는 @AllArgsConstructor
public class BoardController {

	private final BoardService service;
	
	@GetMapping("/list")
	public void list(Model model, Criteria cri) {
		log.info("list..." + cri);
//		criteria.setPageNum(11);
//		criteria.setAmount(10);
		
		model.addAttribute("list", service.getList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, service.getTotal(cri)));
	}
	
	@GetMapping("/register")
	public void register() {
		log.info("register...");
		
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr){	//등록 후에 다른 곳으로 보내겠다
		log.info("register...");
		service.register(board);
		rttr.addFlashAttribute("result", board.getBno());	//화면상에 1번만 전달. 새로고침하면 사라짐
															//addAttribute -> 전달되지 않음. Model로 전달해야 함.
		return "redirect:/board/list";
	}
	
//	@GetMapping("/get")
//	public void get(Long bno, Model model) {
//		log.info("get...");
//		BoardVO boardVO = service.get(bno);
//		model.addAttribute("board", boardVO);
//	}

	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri , Model model) {
		log.info("get/modify...");
		log.info(bno);
		BoardVO boardVO = service.get(bno);
		model.addAttribute("board", boardVO);
	}
	
	@PostMapping("/remove")
	public String remove(Long bno, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("remove...");
		
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		
//		rttr.addAttribute("pageNum", cri.getPageNum());
//		rttr.addAttribute("amount", cri.getAmount());
//		rttr.addAttribute("type", cri.getType());
//		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/board/list" + cri.getListLink();
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("modify...");
		
		if(service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		}
		
//		rttr.addAttribute("pageNum", cri.getPageNum());
//		rttr.addAttribute("amount", cri.getAmount());
//		rttr.addAttribute("type", cri.getType());
//		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/board/list" + cri.getListLink();
	}
	
}
