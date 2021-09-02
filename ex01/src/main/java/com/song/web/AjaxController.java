package com.song.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class AjaxController {
	@RequestMapping("/e")
	public SampleVO e(SampleVO sample) {
		sample.setName("송호준");
		sample.setAge(20);
		return sample;
	}
}
