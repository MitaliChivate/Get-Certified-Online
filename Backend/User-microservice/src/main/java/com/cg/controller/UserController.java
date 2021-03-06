package com.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.beans.User;
import com.cg.service.UserServiceInterface;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/user")
@Validated
public class UserController {

	@Autowired
	private UserServiceInterface userService;

	/*
	 * "firstName":"Tejaswi","lastName":"Midgule","userName":"Tejaswi27","password":
	 * "Tejaswi123","mobileNo":"9011872311","email":"tmidgule98@gmail.com","gender":
	 * "female", "role":"User","dateOfBirth":"1998-11-27"
	 */

	// http://localhost:9200/user/addUser
	@RequestMapping(value = "/addUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public User addUser(@Valid @RequestBody User user) {
		
		return this.userService.addUser(user);
	}

	// http://localhost:9200/user/getAllUser
	@GetMapping(value = "/getAllUser")
	public List<User> getAllTest() {
		return this.userService.getAllUser();
	}

	// http://localhost:9200/user/deleteUser/12
	@DeleteMapping(value = "/deleteUser/{userId}")
	public void deleteUser(@PathVariable Long userId) {
		this.userService.deleteUser(userId);
	}

	// http://localhost:9200/user/searchUser/1
	@GetMapping(value = "/searchUser/{userId}")
	public User searchUserById(@PathVariable Long userId) {

		return this.userService.searchUser(userId);
	}

	// http://localhost:9200/user/updateUser
	@PutMapping(value = "/updateUser")
	public User updateUser(@RequestBody User user) {

		return this.userService.updateUser(user);

	}

	// http://localhost:9200/user/count
	@GetMapping("/count")
	public long countUser() {
		return this.userService.countUser();

	}

	@PostMapping("/checkEmail")
	public int checkEmail(@RequestBody User user) {
		
		
		return userService.checkEmail(user);
	}
	
	@PostMapping("/checkMobileNo")
	public int checkMobileNo(@RequestBody User user) {
		
		
		return userService.checkMobileNo(user);
	}

}