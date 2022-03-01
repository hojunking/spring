package co.song.web.employee.service;

import java.util.List;

import co.song.web.employee.domain.EmployeeVO;

public interface EmployeeService {
	public List<EmployeeVO> list();
	public List<EmployeeVO> getList(EmployeeVO vo);
}
