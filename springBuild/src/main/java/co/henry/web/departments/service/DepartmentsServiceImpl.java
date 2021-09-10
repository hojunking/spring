package co.henry.web.departments.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.henry.web.employee.domain.DepartmentsVO;
import co.henry.web.departments.mapper.DepartmentsMapper;
@Service
public class DepartmentsServiceImpl implements DepartmentsSerivce {
	@Autowired DepartmentsMapper map;

	@Override
	public List<DepartmentsVO> getList() {
		// TODO Auto-generated method stub
		return map.getList();
	}

	@Override
	public DepartmentsVO read(DepartmentsVO vo) {
		// TODO Auto-generated method stub
		return map.read(vo);
	}

	@Override
	public int delete(DepartmentsVO vo) {
		// TODO Auto-generated method stub
		return map.delete(vo);
	}

	@Override
	public int update(DepartmentsVO vo) {
		// TODO Auto-generated method stub
		return map.update(vo);
	}

	@Override
	public int insert(DepartmentsVO vo) {
		// TODO Auto-generated method stub
		return map.insert(vo);
	}

}
