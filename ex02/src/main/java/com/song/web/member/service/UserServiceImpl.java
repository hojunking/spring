package com.song.web.member.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.song.web.member.domain.UserVO;
import com.song.web.member.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserMapper userDAO;
	@Override
	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}
	@Override
	public List<UserVO> getUserList(UserVO vo) {
		return userDAO.getUserList(vo);
	}
	@Override
	public List<Map> getUserListMap(UserVO vo) {
		return userDAO.getUserListMap(vo);
	}
	public int insertUser(UserVO dto) {		
		return userDAO.insertUser(dto);		
	}
	public int updateUser(UserVO dto) {
		return userDAO.updateUser(dto);
	}
	public int deleteUser(UserVO dto) {
		return userDAO.deleteUser(dto);
	}
}
