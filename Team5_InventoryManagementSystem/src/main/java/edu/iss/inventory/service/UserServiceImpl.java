package edu.iss.inventory.service;

import javax.annotation.Resource;

import edu.iss.inventory.repository.UserRepository;

public class UserServiceImpl implements UserService{

	@Resource
	UserRepository userRepository;
	
	
}
