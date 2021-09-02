package com.song.web;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SampleVO {
	private String name;
	private int age;
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	Date dueDate;
}
