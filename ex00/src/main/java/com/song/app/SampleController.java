package com.song.app;

import java.util.Arrays;
import java.util.List;

//pojo : 상속 X

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.java.Log;

@Log
@Controller // -> 상속 @Controller, @Service, @Repository(=dao)
@RequestMapping("/sample/*")
public class SampleController {
	@GetMapping("/ex01")
	public String ex01(@ModelAttribute("sam") SampleVO vo,Model model) {
		log.info(vo.toString()); //@modelAttribute()를 통해서 default SampleVO를 바꿀 수 있다.
//		model.addAttribute("sampleVO",vo); Model 객체에 넣는 작업을 안해도 된다.
//		sample vo가 model에 자동으로 들어간다. command 객체는 자동으로 들어감.
		model.addAttribute("page","방구맨"); //model 객체에 따로 넣기
		return "sample/ex01";
	}
	//잴 기본적이고 잴 많이 사용하는 방식
	@GetMapping("/ex02")
	public void ex02(@RequestParam String name, 
					@RequestParam(required = false,defaultValue = "10") int age) {
		// String name= request.getparameter("name");
		// @RequestParam("name") String name 두개 다 명시해 줘야하지만
		log.info("name=" + name +" "+ "age=" + age);
		//parameter name과 이름이 같을 땐 ("name") 생략한다.
	}
	
	@RequestMapping("/ex03")
	public void ex03(@RequestParam String[] ids) {
		log.info(Arrays.toString(ids));
		//다중 값 받아올 때 String[] 배열로 
	}
	
	@RequestMapping("/ex04")
	public void ex04(@RequestParam List<String> ids) {
		log.info(ids.toString());
		//다중 값 받아올 때 List<string> 배열로 
	}
	
	@RequestMapping("/ex05")
	public void ex05(SampleVoList list) {
		log.info(list.toString());
		//다중 값 받아올 때 List<string> 배열로 
	}
	@RequestMapping("/ex06/{name}/{age}")
	public void ex06(@PathVariable String name,@PathVariable int age) {
		log.info("name="+name+"age="+age);
		
	}
	@RequestMapping("/ex09")
	@ResponseBody
	public SampleVO	ex09(SampleVO sample) {
		sample.setName("송호준");
		sample.setAge(25);
		return sample;
	}

//	@RequestMapping(value = "/a", method = RequestMethod.POST) ==@postMapping
	@GetMapping("/a") // @GetMapping("/a")도 가능하다
	public String basic() {
		log.info("basic......");
		return "sample/basica"; // jsp 뷰페이지 리턴
	}

	@RequestMapping("/b")
	public void basic2() { // void인 경우 url과 일치하는 뷰페이지로 포워드
		log.info("basic....2");
	}

}
