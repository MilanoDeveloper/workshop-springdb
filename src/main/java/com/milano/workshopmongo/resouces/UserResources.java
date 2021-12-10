package com.milano.workshopmongo.resouces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.milano.workshopmongo.domain.User;

@RestController
@RequestMapping("/users")
public class UserResources {
	
	@RequestMapping(method= RequestMethod.GET)
	public ResponseEntity<List<User>>  findAll() {
		User maria   = new User("1", "Maria Silva", "maria@gmail.com");
		User gabriel = new User("1", "gabriel Silva", "gabriel@gmail.com");
		User jonas   = new User("1", "jonas Silva", "jonas@gmail.com");
		
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, gabriel, jonas));
		
		return ResponseEntity.ok().body(list);
		
	}
	
}
