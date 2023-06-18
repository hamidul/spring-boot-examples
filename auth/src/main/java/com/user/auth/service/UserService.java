package com.user.auth.service;

import com.user.auth.dto.LoginDTO;
import com.user.auth.dto.UserDTO;
import com.user.auth.entity.User;
import com.user.auth.response.LoginMessage;


public interface UserService {

	User createUser(UserDTO userDTO);

	LoginMessage login(LoginDTO loginDTO);

}
