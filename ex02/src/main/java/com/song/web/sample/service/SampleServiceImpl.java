package com.song.web.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.song.web.sample.mapper.Sample1Mapper;
import com.song.web.sample.mapper.Sample2Mapper;
@Service
public class SampleServiceImpl implements SampleService {
	
		@Autowired Sample1Mapper sample1;
		@Autowired Sample2Mapper sample2;
	@Override
//	@Transactional
//(noRaollback for) 롤백X 설정도 가능
	public void addData(String value) {
		sample1.insert(value);
		sample2.insert(value);
		
	}
	

}
