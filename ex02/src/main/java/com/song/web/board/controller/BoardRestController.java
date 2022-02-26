package com.song.web.board.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.song.web.board.domain.BoardVO;

@Controller

//@RestController => return 값이 넘어간다. -> json,xml,text
public class BoardRestController {
	@RequestMapping("test1")
	@ResponseBody
	public Map<String,Object> test1(@RequestParam String id) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("id",id);

		if(id.equals("admin")) {
			map.put("result",true);
		}else {
			map.put("result", false);
		}
			return map;  //hello.jsp
			
			//login할 때 유용합니다.
	}
	
	@PostMapping(value="test2") //test?id ->test/id 
					//value값이랑 같다.
//					produces = {MediaType.APPLICATION_XML_VALUE,
//								MediaType.APPLICATION_JSON_VALUE})
	//XML파일로 변환
	@ResponseBody
	public BoardVO test2(BoardVO vo) {
		vo.setBno(10);
		vo.setContent("dddd");
		vo.setRegdate(new Date());
		return vo;
		//자동 jason형식으로 변환해서 보낸다 -->jackson-core
	}
}
