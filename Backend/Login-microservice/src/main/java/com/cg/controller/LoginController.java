package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bean.Login;
import com.cg.bean.User;
import com.cg.service.LoginService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/authentication")
public class LoginController {

	@Autowired
	private LoginService service;

	// { "firstName": "Ajinkya","lastName": "Hase","userName"
	// :"ajinkyahase007","password" :"password", "mobileNo" : 9867543665, "email" :
	// "ajinkyahase007@gmail.com", "gender": "Male", "dateOfBirth": "1998-10-25"}

	@PostMapping("/login")
	public User loginUser(@RequestBody Login user) {

		return service.loginUser(user);

	}

}