package com.blog.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.Model.Users;
import com.blog.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Users registertheUser(Users users) throws Exception {
		
		emailService.sendRegistrationEmail(users.getEmail(), users.getName());
		
		return userRepository.save(users);
		
	}

}
