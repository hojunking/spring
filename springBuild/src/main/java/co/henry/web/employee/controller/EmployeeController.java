package co.henry.web.employee.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.henry.web.board.domain.Criteria;
import co.henry.web.board.domain.PageVO;
import co.henry.web.departments.service.DepartmentsSerivce;
import co.henry.web.employee.domain.EmployeeVO;
import co.henry.web.employee.service.EmployeeSerivce;
import co.henry.web.job.service.JobService;
	
	@Controller
	@RequestMapping("/member/*")
	public class EmployeeController {
		
		@Autowired EmployeeSerivce service; //serviceImpl 부르지마라
		@Autowired JobService jobsservice;
		@Autowired DepartmentsSerivce deptservice;
		//전체조회
		@GetMapping("/listEmp")
		public void list(Model model,@ModelAttribute("cri") Criteria cri) {
			System.out.println("cri==="+cri);
			int total=service.getTotalCount(cri);
			model.addAttribute("list",service.getList(cri));
			model.addAttribute("pageMaker", new PageVO(total, cri));
		}
		@ModelAttribute("opt")
		public Map<String, Object> jobs(){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("jobs", jobsservice.getList());
			map.put("depts", deptservice.getList());
			System.out.println(map);
			return map;
		}//등록폼
		@GetMapping("/insertEmp")
		public String insertFormEmp(EmployeeVO vo) {
			return "member/insertEmp";
		}
		//등록폼
	  @PostMapping("/insertEmp")
	  public String insert(EmployeeVO vo,RedirectAttributes rttr) {
		  System.out.println("여기로 와라!"+vo);
		  service.insert(vo);
		  rttr.addFlashAttribute("result",vo.getEmployeeId());
		  return "redirect:/member/listEmp";
	  }
	  //수정폼
	  @PostMapping("/updateEmp")
	  public String updateForm(EmployeeVO vo,Model model) {
		  model.addAttribute("emp",service.read(vo));
		  return "member/insertEmp";
	  }
	  
	@RequestMapping("/empSearch")
	public String empSearch(Model model,EmployeeVO vo,Criteria cri) {
		cri.setAmount(10);
		model.addAttribute("list",service.getList(cri));
		return "member/empSearch";
	}
	
	@RequestMapping("/ajaxEmp")
	@ResponseBody
	public EmployeeVO ajaxEmp(EmployeeVO vo) {
		return service.read(vo);
		
	}
	
	@RequestMapping("/ajaxEmail")
	@ResponseBody
	public EmployeeVO ajaxEmail(EmployeeVO vo) {
		return service.getByEmail(vo);
		
	}
		
}
