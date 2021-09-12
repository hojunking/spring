package co.henry.web.departments.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.henry.web.departments.service.DepartmentsSerivce;
import co.henry.web.employee.domain.DepartmentsVO;

@Controller
public class DepartmentsController {
	@Autowired DepartmentsSerivce deptservice;
	
	//부서관리 페이지
	@GetMapping("dept")
	public String dept() {
		return "dept/dept";
	}
	
	//ajax를 통한 crud
	@GetMapping("deptList")
	@ResponseBody
	public List<DepartmentsVO> deptList(){
		return deptservice.getList();
	}
	/*
	 * @ModelAttribute("opt") public Map<String,Object> select(){ Map<String,Object>
	 * map = new HashMap<String, Object>(); map.put(", map)
	 * 
	 * }
	 */
	
	@PostMapping("insert")
	@ResponseBody
	public boolean insertDept(DepartmentsVO vo) {
		int r= deptservice.insert(vo);
		System.out.println(r+"확인요"+vo);
		if(r==1) {
			return true;
		}else
		return false;
	}
	@GetMapping("read")
	public void read (Model model,DepartmentsVO vo) {
		model.addAttribute("dept",deptservice.read(vo));
		
	}
//	@PostMapping("update")
//	public 
	
	
}
