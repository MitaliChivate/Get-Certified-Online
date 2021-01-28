package com.cg.beans;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

	private Long userId;

	private String firstName;

	private String lastName;

	private String userName;

	private String password;

	private String mobileNo;

	private String email;

	private String gender;

	private String role;

	private LocalDate dateOfBirth;

}
