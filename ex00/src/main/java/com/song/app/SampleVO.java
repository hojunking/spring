package com.song.app;



import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//생성자 생성 대신해주기
//java.util을 사용하세요!!!!
public class SampleVO {
	private String name;
	private int age;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date dueDate;
	
}
