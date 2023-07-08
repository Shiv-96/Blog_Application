package com.blog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.Model.Users;
import com.blog.Service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<Users> registerTheUserHandler(@Valid @RequestBody Users users) throws Exception {
		
		return new ResponseEntity<>(userService.registertheUser(users), HttpStatus.ACCEPTED);
		
	}
	
}
