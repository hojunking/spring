package com.song.app;

public class BuilderTest {

	public static void main(String[] args) {

		Member member = new Member().builder()
							.id("aa")
							.pw("aaa")
							.build();
		
//		Member member = new Member();
	}

}
