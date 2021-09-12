package co.henry.web.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.henry.web.board.domain.BoardVO;
import co.henry.web.board.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired BoardService service;
	
	@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("list",service.getList());
		
	}
	@GetMapping("/get")
	public void get(Model model,BoardVO vo) {
		model.addAttribute("board",service.read(vo));
	}
	@GetMapping("/register")
	public void registerForm() {}
	
	@PostMapping("/register")
	public String register(BoardVO vo,RedirectAttributes rttr) {
		service.insert(vo);
		rttr.addAttribute("result", vo.getBno());
		return "redirect:/board/list";
	}
	@PostMapping("/delete")
	public String delete(BoardVO vo,RedirectAttributes rttr) {
		int result= service.delete(vo);
		if(result==1) {
			rttr.addAttribute("result","삭제완료");
		}
		return "redirect:/board/list";
	}
	@PostMapping("/modify")
	public String modify(BoardVO vo,RedirectAttributes rttr) {
		service.modify(vo);
		return "redirect:/board/list";
	}
}
