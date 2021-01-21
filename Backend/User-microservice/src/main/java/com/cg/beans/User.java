package com.cg.beans;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

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

	@Column
	@NotNull(message = "First name can not be empty")
	@Size(min = 3, message = "First name must contain at least 3 characters")
	private String firstName;

	@Column
	@NotNull(message = "Last name can not be empty")
	@Size(min = 3, message = "Last name must contain at least 3 characters")
	private String lastName;

	@Column
	@NotNull(message = "Username can not be empty")
	@Size(min = 3, message = "Username must contain at least 3 characters")
	private String userName;

	@Column
	@NotNull(message = "Password can not be empty")
	@Size(min = 3, message = "Password must contain at least 3 characters")
	private String password;
	
	@Column
	@NotNull(message = "Mobile can not be empty")
	@Size(min=10, message = "Mobile must contain at least 10 digits")
	private String mobileNo;

	@Column
	@NotNull(message = "Email can not be empty")
	@Email
	private String email;

	@Column
	@NotEmpty(message = "Gender can not be empty")
	private String gender;

	@Column
	private String role;

	@Column
	@NotNull(message = "DateOfBirth can not be empty")
	@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
	private LocalDate dateOfBirth;
	
	

}
