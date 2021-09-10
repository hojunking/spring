package co.henry.web.departments.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import co.henry.web.departments.service.DepartmentsSerivce;
import co.henry.web.employee.domain.DepartmentsVO;

@Controller
public class DepartmentsController {
	@Autowired DepartmentsSerivce deptservice;
	
	//부서관리 페이지
	@GetMapping("dept")
	public String dept() {
		return "dept/dept";
	}
	
	//ajax를 통한 crud
	@GetMapping("deptList")
	@ResponseBody
	public List<DepartmentsVO> deptList(){
		return deptservice.getList();
	}
	
	@PutMapping("insert")
	public DepartmentsVO insertDept(@RequestBody DepartmentsVO vo) {
		deptservice.insert(vo);
		return vo;
	}
	
}
