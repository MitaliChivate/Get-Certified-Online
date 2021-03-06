package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@PostMapping("/register")
	public User registerUser(@RequestBody User user) {
		
		return service.addUser(user);
		
	}
	
	@PostMapping("/checkEmail")
	public int checkEmail(@RequestBody User user) {
		
		
		return service.checkEmail(user);
	}
	
	@PostMapping("/checkMobileNo")
	public int checkMobileNo(@RequestBody User user) {
		
		
		return service.checkMobileNo(user);
	}
	
	@GetMapping("/checkUserName/{username}")
	public long checkUserName(@PathVariable String username) {
		
		
		return service.checkUserName(username);
	}
	
	@PostMapping("/checkSecurityAnswer/{id}/{answer}")
	public long checkSecurityAnswer(@PathVariable long id ,@PathVariable String answer) {
		
		
		return service.checkSecurityAnswer(id,answer);
	}
	
	@GetMapping("/resetPassword/{id}/{newPassword}")
	public long resetPassword(@PathVariable long id ,@PathVariable String newPassword) {
		
		return service.resetPassword(id,newPassword);
	}
	
	@GetMapping("/findById/{id}")
	public User findByUserId(@PathVariable long id){
		return service.findUserById(id);
	}
	
	
}
