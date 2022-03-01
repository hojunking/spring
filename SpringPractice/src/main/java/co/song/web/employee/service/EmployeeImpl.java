package co.song.web.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.song.web.employee.domain.EmployeeVO;
import co.song.web.employee.mapper.EmployeeMapper;
@Service
public class EmployeeImpl implements EmployeeService {
	@Autowired EmployeeMapper map;
	@Override
	public List<EmployeeVO> list() {
		return map.list();
	}
	@Override
	public List<EmployeeVO> getList(EmployeeVO vo) {
		return map.getList(vo);
	}
	@Override
	public int insert(EmployeeVO vo) {
		// TODO Auto-generated method stub
		return map.insert(vo);
	}
	@Override
	public int update(EmployeeVO vo) {
		// TODO Auto-generated method stub
		return map.update(vo);
	}
	@Override
	public int delete(EmployeeVO vo) {
		// TODO Auto-generated method stub
		return map.delete(vo);
	}

}
