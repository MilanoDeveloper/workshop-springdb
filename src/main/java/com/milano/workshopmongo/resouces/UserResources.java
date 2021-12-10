package com.milano.workshopmongo.resouces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.milano.workshopmongo.domain.User;
import com.milano.workshopmongo.services.UserService;

@RestController
@RequestMapping("/users")
public class UserResources {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method= RequestMethod.GET)
	public ResponseEntity<List<User>>  findAll() {
		
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
}
