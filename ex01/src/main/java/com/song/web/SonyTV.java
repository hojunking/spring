package com.song.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//@Component
public class SonyTV implements TV {
	@Autowired Speaker speaker;
	@Override
	public void turnon() {
		System.out.println("Sony TV Turnon");
	}
	@Override
	public void turnoff() {
		System.out.println("Sony TV Turnff");
	}
	@Override
	public void volumeUp() {
		speaker.volumeUp();
	}
	@Override
	public void volumeDown() {
		speaker.volumeDown();
	}
}
