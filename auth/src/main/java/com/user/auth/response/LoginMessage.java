package com.user.auth.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginMessage {

	private String message;
	private Boolean status;

	public LoginMessage(String message, boolean status) { 
		this.message = message;
		this.status = status;
	}
}
