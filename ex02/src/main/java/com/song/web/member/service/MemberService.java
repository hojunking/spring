package com.song.web.member.service;


import java.util.List;

import com.song.web.board.domain.Criteria;
import com.song.web.member.domain.EmployeeVO;

public interface MemberService {
	public List<EmployeeVO> getList(Criteria cri);
	public EmployeeVO read(EmployeeVO vo);
	public int getTotalCount(Criteria cri);
}
