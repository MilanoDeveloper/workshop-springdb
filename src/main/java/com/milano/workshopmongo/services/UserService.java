package com.milano.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milano.workshopmongo.domain.User;
import com.milano.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	public UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
}
