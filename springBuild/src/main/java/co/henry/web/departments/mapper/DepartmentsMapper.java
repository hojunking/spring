package co.henry.web.departments.mapper;

import java.util.List;

import co.henry.web.employee.domain.DepartmentsVO;

public interface DepartmentsMapper {
	public List<DepartmentsVO> getList();
	public DepartmentsVO read(DepartmentsVO vo);
	public int delete(DepartmentsVO vo);
	public int update(DepartmentsVO vo);
	public int insert(DepartmentsVO vo);
}
