package co.henry.web.board.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import co.henry.web.board.domain.BoardVO;


@RestController
public class HelloWorldController {

	
	//requestMapping(method=RequestMethod.GET
	@GetMapping("/hello")
	public String hello_world() {
		return "Hello World";
	}
	@GetMapping("/helloBean")
	public BoardVO helloWorld() {
		return new BoardVO(0, "hello", null, null, null, null);
	}
	
}
