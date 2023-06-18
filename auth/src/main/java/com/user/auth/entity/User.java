package com.user.auth.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "USER")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	@NonNull
	@Column(unique = true)
	private String userEmail;
	@Column
	private String userPrefix;
	@NonNull
	@Column
	private String userFirstName;
	@Column
	private String userMiddleName;
	@NonNull
	@Column
	private String userLastName;
	@Column
	private Date userBirthDate;
	@Column
	private String userPhoneNumber;
	@Column
	private String userAddress;
	@NonNull
	@Column
	private String userPassword;

}
