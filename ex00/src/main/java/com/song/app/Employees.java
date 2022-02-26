package com.song.app;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Employees {
	private String employee_id;
	private String first_name;
	private String job_id;
}
