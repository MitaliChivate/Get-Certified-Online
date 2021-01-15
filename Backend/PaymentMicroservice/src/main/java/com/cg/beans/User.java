package com.cg.beans;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

	private long userId;

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
