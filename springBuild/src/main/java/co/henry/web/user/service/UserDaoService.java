package co.henry.web.user.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import co.henry.web.board.domain.UserVO;
@Service
public class UserDaoService {
	private static List<UserVO> users= new ArrayList<UserVO>(); //이미들어가 있는 값들
	
	private static int UserCount =3;
	
	static {
		
		users.add(new UserVO(1,"song", new Date(),"pass1","101110-1718212"));
		users.add(new UserVO(2,"hong", new Date() ,"pass2","102110-1828182"));
		users.add(new UserVO(3,"jang", new Date() ,"pass3","103101-1818181"));
	}
	public List<UserVO> findAll(){
		return users;
	}
	
	public UserVO save(UserVO user) {
		if(user.getId()==null) {
			user.setId(++UserCount);
		}
		users.add(user);
		return user;
	}
	public UserVO findOne(int id) {
		for(UserVO user: users) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}
	public UserVO delete(int id) {
		Iterator<UserVO> iterator = users.iterator();
		
		while(iterator.hasNext()) { //하나씩 가져오기
			UserVO user= iterator.next(); //users data에 순차적으로 포함도니다.
		if(user.getId() ==id) {
			iterator.remove();
			return user;
		}
		}
		return null;
	}
	
	public UserVO update(UserVO vo) {
		Iterator<UserVO> iterator = users.iterator();
		
		while(iterator.hasNext()) {
			UserVO user= iterator.next();
			if(user.getId() == vo.getId()) {
				user.setName(vo.getName());
				user.setJoinDate(vo.getJoinDate());
				return user;
			}
		}
		return null;
	}
}
