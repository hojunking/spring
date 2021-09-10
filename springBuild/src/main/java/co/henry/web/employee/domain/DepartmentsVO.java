package co.henry.web.employee.domain;

import lombok.Data;

@Data
public class DepartmentsVO {
	private	long	departmentId;
	private	String	departmentName;
	private	long	managerId;
	private	long	locationId;
}
