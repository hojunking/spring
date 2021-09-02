package com.song.app;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //@Controller + @ResponseBody(자바객체 -> json 스트링변환)
//ajax전용 컨트롤러
public class AjaxController {
	@RequestMapping("/ex07")
	public SampleVO	ex07(SampleVO sample) {
		sample.setName("송호준");
		sample.setAge(25);
		return sample;
	}
	@RequestMapping("/ex08")
	public List<SampleVO>	ex08() {
		List<SampleVO> list= new ArrayList<>();
		list.add(new SampleVO("song",10,new Date()));
		list.add(new SampleVO("dong",12,new Date()));
		list.add(new SampleVO("sing",15,new Date()));
		return list;
	}
}
