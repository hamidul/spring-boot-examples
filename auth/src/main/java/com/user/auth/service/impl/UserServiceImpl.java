package com.user.auth.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.user.auth.dto.LoginDTO;
import com.user.auth.dto.UserDTO;
import com.user.auth.entity.User;
import com.user.auth.repo.UserRepo;
import com.user.auth.response.LoginMessage;
import com.user.auth.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User createUser(UserDTO userDTO) {
		String encodedPassword = passwordEncoder.encode(userDTO.getUserPassword());
		User user = User.builder()
				.userFirstName(userDTO.getUserFirstName())
				.userMiddleName(userDTO.getUserMiddleName())
				.userLastName(userDTO.getUserLastName())
				.userEmail(userDTO.getUserEmail())
				.userPassword(encodedPassword)
				.userPrefix(userDTO.getUserPrefix())
				.userPhoneNumber(userDTO.getUserPhoneNumber())
				.userAddress(userDTO.getUserAddress())
				.userBirthDate(userDTO.getUserBirthDate())
				.build();
		return userRepo.save(user);
	}

	@Override
	public LoginMessage login(LoginDTO loginDTO) {
		User user = userRepo.findByUserEmail(loginDTO.getUserEmail());
		if (user != null) {
			String password = loginDTO.getUserPassword();
			String encodedPassword = user.getUserPassword();
			Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
			if (isPwdRight) {
				Optional<User> employee = userRepo.findOneByUserEmailAndUserPassword(loginDTO.getUserEmail(), encodedPassword);
				if (employee.isPresent()) {
					return new LoginMessage("Login Success", true);
				} else {
					return new LoginMessage("Login Failed", false);
				}
			} else {

				return new LoginMessage("password Not Match", false);
			}
		} else {
			return new LoginMessage("Email not exits", false);
		}

	}

}
