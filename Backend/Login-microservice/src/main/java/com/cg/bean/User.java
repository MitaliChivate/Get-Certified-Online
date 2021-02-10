package com.cg.bean;

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

@Entity
@Table(name = "User")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_sequence")
	@SequenceGenerator(name = "user_id_sequence", initialValue = 100000, allocationSize = 1)
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
	
	private String securityQuestion;
	
	private String securityAnswer;

}
