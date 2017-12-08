package edu.iss.inventory.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.iss.inventory.model.User;
import edu.iss.inventory.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Resource
	UserRepository userRepository;
	
	@Override
	@Transactional
	public User getUserByUserId(String userId) {
		return userRepository.findUserByUserId(userId);

	}	
}
