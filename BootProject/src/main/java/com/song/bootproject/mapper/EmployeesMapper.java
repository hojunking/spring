package com.song.bootproject.mapper;

import com.song.bootproject.domain.EmployeeVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface EmployeesMapper {
    public List<EmployeeVO> getList();
    public EmployeeVO read(EmployeeVO vo);
    public int delete(EmployeeVO vo);
    public int update(EmployeeVO vo);
    public int insert(EmployeeVO vo);
}
