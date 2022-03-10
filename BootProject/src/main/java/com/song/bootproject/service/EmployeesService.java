package com.song.bootproject.service;

import com.song.bootproject.domain.EmployeeVO;
import java.util.List;

public interface EmployeesService {
    public List<EmployeeVO> getList();
    public EmployeeVO read(EmployeeVO vo);
    public int delete(EmployeeVO vo);
    public int update(EmployeeVO vo);
    public int insert(EmployeeVO vo);
}
