package co.henry.web.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.henry.web.board.domain.Criteria;
import co.henry.web.employee.domain.EmployeeVO;
import co.henry.web.employee.mapper.EmployeeMapper;
@Service
public class EmployeeServiceImpl implements EmployeeSerivce {
	@Autowired EmployeeMapper map;


	@Override
	public EmployeeVO read(EmployeeVO vo) {
		return map.read(vo);
	}

	@Override
	public int delete(EmployeeVO vo) {
		// TODO Auto-generated method stub
		return map.delete(vo);
	}

	@Override
	public int update(EmployeeVO vo) {
		// TODO Auto-generated method stub
		return map.update(vo);
	}

	@Override
	public int insert(EmployeeVO vo) {
		// TODO Auto-generated method stub
		return map.insert(vo);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		// TODO Auto-generated method stub
		return map.getTotalCount(cri);
	}

	@Override
	public List<EmployeeVO> getList(Criteria cri) {
		// TODO Auto-generated method stub
		return map.getList(cri);
	}

	@Override
	public EmployeeVO getByEmail(EmployeeVO vo) {
		// TODO Auto-generated method stub
		return map.getByEmail(vo);
	}

}
