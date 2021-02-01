package com.cg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.beans.User;
import com.cg.service.UserServiceImpl;

@SpringBootTest
class UserMicroserviceApplicationTests {

	@Test
	public void addUserTest() {

		User user = new User(4l, "Tejaswi", "Midgule", "Admin1", "root", "9874563210", "abc@gmail.com", "Female",
				"User", LocalDate.now());

		UserServiceImpl userService = mock(UserServiceImpl.class);

		when(userService.addUser(user)).thenReturn(user);

		User user1 = userService.addUser(user);

		assertEquals(user, user1);

	}

	@Test
	void findAllUsers()
	{
		

		List<User> u1 = new ArrayList<>(); 
		User user = new User(4l, "Tejaswi", "Midgule", "Admin1", "root", "9874563210", "abc@gmail.com", "Female",
				"User", LocalDate.now());
		User user1 = new User(5l, "Teju", "Midgule", "Admin12", "root12", "9874563280", "abc1@gmail.com", "Female",
				"User", LocalDate.now());
		
		u1.add(user);
		u1.add(user1);
		
		
		UserServiceImpl service = mock(UserServiceImpl.class);
		
		when(service.getAllUser()).thenReturn(u1);
		List<User> u2 = service.getAllUser();
		assertNotNull(u2);
		assertFalse(u2.isEmpty());
	}
	
	@Test
	public void updateUser() {
		
		User user = new User(4l, "Tejaswi", "Midgule", "Admin1", "root", "9874563210", "abc@gmail.com", "Female",
				"User", LocalDate.now());

		UserServiceImpl userService = mock(UserServiceImpl.class);

		userService.addUser(user);

		User user1 = new User(4l, "Teju", "Midgule", "Admin1", "root", "9874563210", "abc@gmail.com", "Female",
				"User", LocalDate.now());

		when(userService.updateUser(user1)).thenReturn(user1);
		User user2 = userService.updateUser(user1);
		assertEquals(user1, user2);

	}

}
