package co.henry.web.employee.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeVO {
	private long employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	private Date hireDate;
	private String jobId;
	private long salary;
	private double commissionPct;
	private long managerId;
	private long departmentId;
}