package com.song.web.board.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.song.web.board.domain.Criteria;
import com.song.web.board.domain.ReplyPageVO;
import com.song.web.board.domain.ReplyVO;
import com.song.web.board.service.ReplyService;

@RestController
@RequestMapping("/reply/*")
public class ReplyRestController {
	@Autowired ReplyService replyService;
	
	//게시글 댓글만
	@GetMapping("/")
	public ReplyPageVO getListPage(Criteria cri,
			@RequestParam Long bno){
		return replyService.getListPage(cri, bno);
		
	}
	//댓글조회
	@GetMapping("/{rno}")
	public ReplyVO read(@PathVariable Long rno, ReplyVO vo){
		vo.setRno(rno);
		return replyService.read(vo);
	}
	//추가
	@PostMapping("/") //post : 파라미터 질의문자열(query string) -> ?id=100&pwd=111&name=song
	public ReplyVO insert(ReplyVO vo) {
		replyService.insert(vo);
		return replyService.read(vo);
	}
	//수정 
	@PutMapping("/")   //put : 파라미터는 json타입만 가능{id:100,pw:"111",name:"song"}
	public ReplyVO modify(@RequestBody ReplyVO vo) {
		replyService.modify(vo);
		return replyService.read(vo);
	}
	//삭제
	@DeleteMapping("/{rno}")
	public boolean delete(@PathVariable Long rno,ReplyVO vo) {
		vo.setRno(rno);
		int r= replyService.delete(vo); 
		return r==1 ? true : false;
	}
	
	//삭제
	/*
	 * @PostMapping("/delete") public boolean delete(ReplyVO vo) { int r=
	 * replyService.delete(vo); return r==1 ? true : false; }
	 */
	//수정
//	@PostMapping("/modify")
//	public ReplyVO modify(ReplyVO vo) {
//		replyService.modify(vo);
//		return vo;
//	}
}
