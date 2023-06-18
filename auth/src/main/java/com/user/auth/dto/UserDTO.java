package com.user.auth.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

	private Integer userId;

	private String userEmail;

	private String userPrefix;

	private String userFirstName;

	private String userMiddleName;

	private String userLastName;

	private Date userBirthDate;

	private String userPhoneNumber;

	private String userAddress;

	private String userPassword;
}
