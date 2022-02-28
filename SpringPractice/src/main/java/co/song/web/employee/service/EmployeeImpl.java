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
	public List<EmployeeVO> getList() {
		
		return map.getList();
	}

}
