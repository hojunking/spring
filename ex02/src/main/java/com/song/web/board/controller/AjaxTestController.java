package com.song.web.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.song.web.board.domain.BoardVO;

@Controller
public class AjaxTestController {
	
	@GetMapping("ajax1")  //get은 json으로 보낼 수 없다.
	@ResponseBody
	public BoardVO test1(BoardVO vo) {
		vo.setContent("content test");
		return vo;
	}
	@PostMapping("ajax2") //get은 json으로 보낼 수 없다. formdata 안에 넣어서 간다(post)
	@ResponseBody
	public BoardVO test2(@RequestBody BoardVO vo) { //requestbody->json으로 보내는거다
		vo.setContent("content test");
		return vo;
	} 
}
