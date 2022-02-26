package co.henry.web.employee.domain;

import lombok.Data;

@Data

public class JobsVO {
	private	String jobId;
	private	String jobTitle;
	private	int minSalary;
	private	int maxSalary;
}
