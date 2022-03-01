package co.song.web.employee.mapper;

import java.util.List;

import co.song.web.employee.domain.EmployeeVO;

public interface EmployeeMapper {
	public List<EmployeeVO> list();
	public List<EmployeeVO> getList(EmployeeVO vo);
}
