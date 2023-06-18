package com.user.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.auth.dto.LoginDTO;
import com.user.auth.dto.UserDTO;
import com.user.auth.entity.User;
import com.user.auth.response.LoginMessage;
import com.user.auth.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/create")
	public User createUser(@RequestBody UserDTO userDto) {
		User user = userService.createUser(userDto);
		return user;
	}
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO){
		LoginMessage loginMessage = userService.login(loginDTO);
		return ResponseEntity.ok(loginMessage);
	}

}
