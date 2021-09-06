package com.song.web.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.song.web.board.domain.Criteria;
import com.song.web.board.domain.PageVO;
import com.song.web.member.service.MemberServiceImpl;

@Controller
@RequestMapping("/member/*")
public class MemberComtroller {
	
	@Autowired MemberServiceImpl memberService;
	//전체조회
	@GetMapping("/list")
	public void list(Model model,@ModelAttribute("cri") Criteria cri) {
		System.out.println("cri==="+cri);
		int total=memberService.getTotalCount(cri);
		model.addAttribute("list",memberService.getList(cri));
		model.addAttribute("pageMaker", new PageVO(total, cri));
	}
}
