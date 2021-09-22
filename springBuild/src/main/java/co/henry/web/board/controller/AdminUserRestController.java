package co.henry.web.board.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fasterxml.jackson.databind.util.BeanUtil;

import co.henry.web.board.domain.UserVO;
import co.henry.web.board.domain.UserVOV2;
import co.henry.web.user.exception.UserNotFoundException;
import co.henry.web.user.service.UserDaoService;

@RestController

public class AdminUserRestController {
	
@Autowired UserDaoService service;
	@GetMapping("admin/users")
	public MappingJacksonValue AllUser(){
		List<UserVO> vo = service.findAll();
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
		.filterOutAllExcept("id","name","joinDate","password","ssn");
		
		FilterProvider filters =new SimpleFilterProvider().addFilter("UserInfo",filter);
		
		MappingJacksonValue map = new MappingJacksonValue(vo);
		map.setFilters(filters);
		return map;
	}
	//produces -> 마임?? 그거
//	@GetMapping(value="/admin/users/{id}/",params = "version=1") //request parameter versioning ->일반 가능
//	@GetMapping(value="/admin/users/{id}",headers= "X-API-VERSION=1") //일반 브라우저 사용x
	@GetMapping(value="/admin/users/{id}", produces = "application/vnd.company.appv1+json")
	public MappingJacksonValue OneUserV1(@PathVariable Integer id) {
		UserVO user =  service.findOne(id);
		
		if(user==null) {
			throw new UserNotFoundException(String.format("ID[%s] Not Found!!", id));
		}
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
		.filterOutAllExcept("id","name","joinDate","password","ssn");
		
		FilterProvider filters =new SimpleFilterProvider().addFilter("UserInfo",filter);
		
		MappingJacksonValue map = new MappingJacksonValue(user);
		map.setFilters(filters);
		
		
		return map;
	}
	
	//uri versioning -> uri 주소 앞에 v1넣은거
	//parameter값은 ?다음 version uri
//	@GetMapping(value="/admin/users/{id}/",params = "version=2")
//	@GetMapping(value="/admin/users/{id}",headers= "X-API-VERSION=2")
	@GetMapping(value="/admin/users/{id}", produces = "application/vnd.company.appv2+json")
	public MappingJacksonValue OneUserV2(@PathVariable Integer id) {
		UserVO user =  service.findOne(id);
		if(user==null) {
			throw new UserNotFoundException(String.format("ID[%s] Not Found!!", id));
		}
		
		// User -> User2
		UserVOV2 user2 =new UserVOV2();
//		user2.setId(user.getId());
		BeanUtils.copyProperties(user, user2);
		user2.setGrade("VIP");
		
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
		.filterOutAllExcept("id","name","joinDate","password","ssn","grade");
		
		FilterProvider filters =new SimpleFilterProvider().addFilter("UserInfoV2",filter);
		
		MappingJacksonValue map = new MappingJacksonValue(user2);
		map.setFilters(filters);
		
		
		return map;
	}

}
