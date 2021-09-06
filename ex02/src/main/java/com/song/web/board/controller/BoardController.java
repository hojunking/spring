package com.song.web.board.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.song.web.board.domain.BoardVO;
import com.song.web.board.domain.Criteria;
import com.song.web.board.domain.PageVO;
import com.song.web.board.service.BoardService;


@Controller
@RequestMapping("/board/*")
//@SessionAttributes("cri") //cri가 있다면 session 태운다
public class BoardController {
	
	@Autowired BoardService boardService;
	//전체조회
	@GetMapping("/list")
	public void list(Model model,@ModelAttribute("cri") Criteria cri) {
		System.out.println("cri==="+cri);
		int total = boardService.getTotalCount(cri);
		model.addAttribute("list",boardService.getList(cri));
		model.addAttribute("pageMaker", new PageVO(total,cri));
		
	}
	//단건조회(수정페이지)
	@GetMapping("/get")
	public void get(Model model,BoardVO vo,@ModelAttribute("cri") Criteria cri) { //bno 파라미터 던져주기 커맨드객체(vo)
		model.addAttribute("board",boardService.read(vo)); //modelAttribute -> 이름설정 해줄 때
	}
	//수정처리
	@PostMapping("/modify")
	public String modify(BoardVO vo,
						@ModelAttribute("cri") Criteria cri,
						RedirectAttributes rttr ){
		int result= boardService.update(vo);
		if(result == 1) {
			rttr.addFlashAttribute("result","성공!!");
		}
		rttr.addAttribute("pageNum",cri.getPageNum());
		rttr.addAttribute("amount",cri.getAmount());
		return "redirect:/board/list";
	}
	//등록페이지
	@GetMapping("/register")
	public void registerForm() {
		
	}
	//등록처리
	@PostMapping("/register")
	public String register(BoardVO vo,RedirectAttributes rttr){
		//httpservletrequest 객체를 불러 올수도 있다.
		//parameter 값 전달이 되지 않아서 RedirectAttributes라는 객체를 이용해 값을 담아 전달한다
		boardService.insert(vo);
		rttr.addFlashAttribute("result",vo.getBno());
		return "redirect:/board/list";  //redirect는 parameter 전달 X
	}
	//삭제처리
	@PostMapping("/delete")
	public String delete(BoardVO vo,
						@ModelAttribute("cri") Criteria cri,
						RedirectAttributes rttr){
		int result= boardService.delete(vo);
		if(result == 1) {
			rttr.addFlashAttribute("result","삭제성공!!");
		}
		rttr.addAttribute("pageNum",cri.getPageNum());
		rttr.addAttribute("amount",cri.getAmount());  //세션사용으로 없어도 된다.
		return "redirect:/board/list";
	}
	
}
