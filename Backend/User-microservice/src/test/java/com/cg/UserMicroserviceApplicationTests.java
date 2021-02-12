package com.cg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.beans.User;
import com.cg.service.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class UserTest {


	static {
		System.setProperty("spring.profiles.active", "test");
	}

	@Autowired
	private MockMvc mockMvc;

	@Test
	void testFetchUserByIdSuccess() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/user/searchUser/100000").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));

	}

<<<<<<< Updated upstream
@SpringBootTest
class UserMicroserviceApplicationTests {

//	@Test
//	public void addUserTest() {
//
//		User user = new User(4l, "Tejaswi", "Midgule", "Admin1", "root", "9874563210", "abc@gmail.com", "Female",
//				"User", LocalDate.now());
//
//		UserServiceImpl userService = mock(UserServiceImpl.class);
//
//		when(userService.addUser(user)).thenReturn(user);
//
//		User user1 = userService.addUser(user);
//
//		assertEquals(user, user1);
//
//	}
//
//	@Test
//	void findAllUsers()
//	{
//		
//
//		List<User> u1 = new ArrayList<>(); 
//		User user = new User(4l, "Tejaswi", "Midgule", "Admin1", "root", "9874563210", "abc@gmail.com", "Female",
//				"User", LocalDate.now());
//		User user1 = new User(5l, "Teju", "Midgule", "Admin12", "root12", "9874563280", "abc1@gmail.com", "Female",
//				"User", LocalDate.now());
//		
//		u1.add(user);
//		u1.add(user1);
//		
//		
//		UserServiceImpl service = mock(UserServiceImpl.class);
//		
//		when(service.getAllUser()).thenReturn(u1);
//		List<User> u2 = service.getAllUser();
//		assertNotNull(u2);
//		assertFalse(u2.isEmpty());
//	}
//	
//	@Test
//	public void updateUser() {
//		
//		User user = new User(4l, "Tejaswi", "Midgule", "Admin1", "root", "9874563210", "abc@gmail.com", "Female",
//				"User", LocalDate.now());
//
//		UserServiceImpl userService = mock(UserServiceImpl.class);
//
//		userService.addUser(user);
//
//		User user1 = new User(4l, "Teju", "Midgule", "Admin1", "root", "9874563210", "abc@gmail.com", "Female",
//				"User", LocalDate.now());
//
//		when(userService.updateUser(user1)).thenReturn(user1);
//		User user2 = userService.updateUser(user1);
//		assertEquals(user1, user2);
//
//	}

}
=======
	
	 @Test 
	 void testFetchUserByIdFailure() throws Exception {
	 
	  mockMvc.perform(MockMvcRequestBuilders.get("/user/searchUser/100010").contentType(
	  MediaType.APPLICATION_JSON))
	 .andExpect(status().isNotFound());
	  
	  }

		@Test
		void testFetchAllUserSuccess() throws Exception {

			mockMvc.perform(MockMvcRequestBuilders.get("/user/getAllUser").contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));

		}
		
		
		@Test
		void testGetUserCount() throws Exception {
			
			mockMvc.perform(MockMvcRequestBuilders.get("/user/count")
					.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON));
			
		}
		
	
	  @Test void testDeleteUser1Success() throws Exception {
	  mockMvc.perform(MockMvcRequestBuilders.delete("/user/deleteUser/100002").
	  contentType(MediaType.APPLICATION_JSON)) .andExpect(status().isOk()); }
	 
		/*
		public static String asJsonString(final Object obj) {
		    try {
		        return new ObjectMapper().writeValueAsString(obj);
		    } catch (Exception e) {
		        throw new RuntimeException(e);
		    }
		}
		
		@Test
		void testAddUserSuccess() throws Exception {			
			mockMvc.perform(MockMvcRequestBuilders
					.post("/user/addUser")
					.content(asJsonString(new User(100006L, "Tejaswi", "Midgule", "Admin1", "root", "9874563210", "abc@gmail.com", "Female",
							"User", LocalDate.now(),"What is your favourite color?","Blue")))
					.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
			 	
		}
		
		@Test
		void testChangePasswordSuccess() throws Exception {
			

			User user =new User(100002, "Abc", "Xyz", "abc11", "abc123@", "9876543210", "abc@gmail.com", "Female",
					"user", LocalDate.of(1998, 03, 11),"Where is your home?","rto");
				
			mockMvc.perform(MockMvcRequestBuilders
					.put("/user/updateUser")
					.content(asJsonString(new User(100002, "Abc", "Xyz", "abc11", "abc123@", "9876543211", "abc@gmail.com", "Female",
							"user", LocalDate.of(1998, 03, 11),"Where is your home?","sagar")))
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
		}
		
		@Test
		void testAddUserFailure() throws Exception {

				
			mockMvc.perform(MockMvcRequestBuilders
					.post("/user/addUser")
		      .content(asJsonString(new User(100010, "Tejaswi", "Midgule", "Admin1", "root", "9874563210", "abc@gmail.com", "Female",
						"User", LocalDate.now(),"What is your favourite color","Blue")))
		      .contentType(MediaType.APPLICATION_JSON)
		      .accept(MediaType.APPLICATION_JSON))
		      .andExpect(status().isNotFound());
		     
		}
		*/
		@Test
		public void addUserTest() {
			User user = new User(100005L, "Tejaswi", "Midgule", "Admin1", "root", "9874563210", "abc@gmail.com", "Female",
					"User", LocalDate.now(),"What is your favourite color","Blue");

			UserServiceImpl userService = mock(UserServiceImpl.class);

			when(userService.addUser(user)).thenReturn(user);

			User user1 = userService.addUser(user);

			assertEquals(user, user1);

		}

	@Test
		void findAllUsers()
		{
		

			List<User> u1 = new ArrayList<>(); 
			User user = new User(100005L, "Tejaswi", "Midgule", "Admin1", "root", "9874563210", "abc@gmail.com", "Female",
					"User", LocalDate.now(),"What is your favourite color","Blue");
			User user1 = new User(100007L, "Tejaswi", "Midgule", "Admin123", "root12", "9874563310", "affbc@gmail.com", "Female",
					"User", LocalDate.now(),"What is your favourite animal","Dog");
			
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
			User user = new User(100005L, "Tejaswi", "Midgule", "Admin1", "root", "9874563210", "abc@gmail.com", "Female",
					"User", LocalDate.now(),"What is your favourite color","Blue");

			UserServiceImpl userService = mock(UserServiceImpl.class);

			userService.addUser(user);

			User user1 = new User(100006L, "Tejaswi", "Midgule", "Admin1", "root123", "9874563223", "abc@gmail.com", "Female",
					"User", LocalDate.now(),"What is your favourite color","Blue");

			when(userService.updateUser(user1)).thenReturn(user1);
			User user2 = userService.updateUser(user1);
			assertEquals(user1, user2);

		}




}	
>>>>>>> Stashed changes
