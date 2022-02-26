package com.song.app;


import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.song.app.impl.EmpMapper;

import lombok.extern.java.Log;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/*-context.xml")
//root-context.xml property에서 위치 확인 후 위치넣기
public class EmpMapperClient {
	
	@Autowired EmpMapper dao;
	@Autowired SqlSessionTemplate mybatis;
	
	@Test
	public void mybatisTest() {
//		List<Employees> list =mybatis.selectList("com.song.app.impl.EmpMapper.getEmp","10");
		List<Departments> list =mybatis.selectList("com.song.app.impl.EmpMapper.getDept");
//		log.info("job_id="+list.get(0).getJob_id());
		log.info(list.get(0).getDepartment_id());
	}//vo객체를 만들었을 경우엔 getJob_id를 사용, map을 사용할 때 단건조회는 tostring()사용한다.
	
	@Test @Ignore
	public void test() {
		log.info(dao.getEmp("10").toString());

	}
	@Test
	public void getTime() {
		log.info("time=="+dao.getTime());
	}

}
