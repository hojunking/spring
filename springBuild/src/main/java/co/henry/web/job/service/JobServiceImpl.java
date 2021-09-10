package co.henry.web.job.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.henry.web.employee.domain.JobsVO;
import co.henry.web.job.mapper.JobMapper;
@Service
public class JobServiceImpl implements JobService {
	@Autowired JobMapper map;
	@Override
	public List<JobsVO> getList() {
		return map.getList();
	}

}
