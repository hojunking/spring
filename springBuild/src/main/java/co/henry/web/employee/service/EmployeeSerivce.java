package co.henry.web.employee.service;

import java.util.List;

import co.henry.web.board.domain.Criteria;
import co.henry.web.employee.domain.EmployeeVO;

public interface EmployeeSerivce {
	public List<EmployeeVO> getList(Criteria cri);
	public EmployeeVO read(EmployeeVO vo);
	public int delete(EmployeeVO vo);
	public int update(EmployeeVO vo);
	public int insert(EmployeeVO vo);
	public int getTotalCount(Criteria cri);
	public EmployeeVO getByEmail(EmployeeVO vo);
}
