package com.song.bootproject.employees.domain;

import lombok.Data;

@Data
public class EmployeeVO {
    private int employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String hireDate;
    private String jobId;
    private String salary;
    private String commission;
    private String managerId;
    private int departmentId;
}
