package co.henry.web.board.controller;


import java.net.URI;
import java.util.List;

/*import javax.validation.Valid;*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import co.henry.web.board.domain.UserVO;
import co.henry.web.user.exception.UserNotFoundException;
import co.henry.web.user.service.UserDaoService;

@RestController
public class UserRestController {

	@Autowired UserDaoService service;
	
	@GetMapping("/users")
	public List<UserVO> AllUser(){
		return service.findAll();
	}
	
	@GetMapping("/users/{id}")
	public EntityModel<UserVO> OneUser(@PathVariable Integer id) {
		UserVO user =  service.findOne(id);
		
		if(user==null) {
			throw new UserNotFoundException(String.format("ID[%s] Not Found!!", id));
		}
		EntityModel<UserVO> model= new EntityModel<>(user);
		WebMvcLinkBuilder linkTo= WebMvcLinkBuilder.linkTo(
				WebMvcLinkBuilder.methodOn(this.getClass()).AllUser());
		
		model.add(linkTo.withRel("all-users"));
		
		return model;
	}
	
	//insert
	@PostMapping("/users") //requestbody는 json과 같은 object형태를 받기 위해서 사용
	public ResponseEntity<UserVO> insert(/* @Valid */ @RequestBody UserVO vo) {
		service.save(vo);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(vo.getId())
		.toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	//delete
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable Integer id) {
		UserVO user= service.delete(id);
		
		if(user == null) {
			throw new UserNotFoundException(String.format("ID[%s] Not Found!!", id));
		}
	}
	
	
	//update
	@PutMapping("/users")
	public void updateUser(@RequestBody UserVO vo) {
		UserVO user=service.update(vo);
		
		
		if(user == null) {
			throw new UserNotFoundException(String.format("ID[%s] Not Found!!", vo.getId()));
		}
	}
	
	
}
