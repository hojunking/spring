package com.song.web.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.song.web.board.domain.Criteria;
import com.song.web.member.domain.EmployeeVO;
import com.song.web.member.mapper.MemberMapper;
@Service
public class MemberServiceImpl implements MemberService {
	@Autowired MemberMapper map;
	@Override
	public List<EmployeeVO> getList(Criteria cri) {
		return map.getList(cri);
	}
	@Override
	public EmployeeVO read(EmployeeVO vo) {
		return map.read(vo);
	}
	@Override
	public int getTotalCount(Criteria cri) {
		return map.getTotalCount(cri);
	}

}
