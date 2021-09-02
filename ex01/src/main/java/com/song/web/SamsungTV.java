package com.song.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class SamsungTV implements TV{
	@Autowired Speaker speaker;
	@Override
	public void turnon() {
		System.out.println("SamsungTV Turnon");
	}
	@Override
	public void turnoff() {
		System.out.println("SamsungTV Turnff");
		
	}
//인터페이스 설정 시 모듈화해서 메소드를 받는다.
	@Override
	public void volumeUp() {
		speaker.volumeUp();
	}
	@Override
	public void volumeDown() {
		speaker.volumeDown();
	}
}
