package com.cg;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.beans.Exam;

import com.cg.service.ExamServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ExamTests {
	
	
	static {
		System.setProperty("spring.profiles.active", "test");
	}

	@Autowired
	private MockMvc mockMvc;
	
	
	@Test
	void fetchByValidId() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/exam/findByExamId/300024").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));

	}
	
	@Test
	void fetchByIdInvalidRequest() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.post("/exam/findByExamId/300024").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isInternalServerError());

	}
	@Test
	void fetchByIdInvalidRequest1() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.put("/exam/findByExamId/300024").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isInternalServerError());

	}
	@Test
	void fetchByIdInvalidRequest2() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.delete("/exam/findByExamId/300024").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isInternalServerError());

	}
	
	@Test
	void fetchByInvalidId() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/exam/findByExamId/100024").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().is4xxClientError())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.message", Matchers.is("FieldException")));


	}
	
	@Test
	void deleteByValidId() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.delete("/exam/deleteExam/300061").contentType(MediaType.APPLICATION_JSON))
					.andExpect(content().contentType(MediaType.APPLICATION_JSON));

	}
	
	@Test
	void deleteByInvalidId() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.delete("/exam/deleteExam/100030").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().is4xxClientError())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.message", Matchers.is("FieldException")));

	}
	
	
	@Test
	void testGetExamCount() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.get("/exam/count")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		
	}
	
	@Test
	void fetchByValidExamName() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/exam/findByExamName/Core Java").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));

	}
	
	@Test
	void fetchByInvalidExamName() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/exam/findByExamName/Core").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().is4xxClientError())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.message", Matchers.is("FieldException")));

	}
	
	@Test
	void getAllExams() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/exam/getAllExams").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));

	}
	

	@Test
	void testgetAllExams() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.post("/exam/getAllExams").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isInternalServerError());

	}
	
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	  @Test
	  public void insertValidData() throws Exception {
	    ObjectMapper mapper = new ObjectMapper();
	    mapper.registerModule(new JavaTimeModule());
	    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	   
	  //  Exam exam1 = new Exam(00, LocalDate.of(1999, 5, 14), LocalTime.now(), LocalTime.now(),"", 300, "C++ Certifcation Exam" ,200);
	    Exam exam=Exam.builder()
	    		.examId(300100L)
	    		.examDate(LocalDate.of(2021,7,7))
	    		.startTime(LocalTime.now())
	    		.endTime(LocalTime.now())
	    		.examName("C++ Exam")
	    		.examCost(300)
	    		.description("C++ Certifcation Exam")
	    		.availableSeats(20)
	    		.build();
		
	    mockMvc.perform(MockMvcRequestBuilders.post("/exam/addExams")
	    .contentType(MediaType.APPLICATION_JSON)
	    .content(mapper.writeValueAsString(exam)))
	    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
	    .andExpect(status().is2xxSuccessful())
        .andExpect(jsonPath("$.examId").exists());
      
		}
	  
	  @Test
	  public void insertInvalidData() throws Exception {
	    ObjectMapper mapper = new ObjectMapper();
	    mapper.registerModule(new JavaTimeModule());
	    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	   
		    Exam exam=Exam.builder()
	    		.examId(300100)
	    		.examDate(LocalDate.of(2020,7,7))
	    		.startTime(LocalTime.now())
	    		.endTime(LocalTime.now())
	    		.examName("")
	    		.examCost(300)
	    		.description("C++ Certifcation Exam")
	    		.availableSeats(200)
	    		.build();
		
	    mockMvc.perform(MockMvcRequestBuilders.post("/exam/addExams")
	    .contentType(MediaType.APPLICATION_JSON)
	    .content(mapper.writeValueAsString(exam)))
	    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
	    .andExpect(status().is4xxClientError());
       
      
		}

	

	  @Test
		void sendReminder() throws Exception {
		  ObjectMapper mapper = new ObjectMapper();
		  
		  mapper.registerModule(new JavaTimeModule());
		    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		   
		    Exam exam=Exam.builder()
		    		.examId(300034L)
		    		.examDate(LocalDate.of(2021,7,7))
		    		.startTime(LocalTime.now())
		    		.endTime(LocalTime.now())
		    		.examName("C++ Exam")
		    		.examCost(300)
		    		.description("C++ Certifcation Exam")
		    		.availableSeats(20)
		    		.build();
		  
		    mockMvc.perform(MockMvcRequestBuilders.post("/exam/sendReminder/100011")
		    	    .contentType(MediaType.APPLICATION_JSON)
		    	    .content(mapper.writeValueAsString(exam)))
		    	    .andExpect(status().is2xxSuccessful());

		}
	  
	  
	  
	  @Test
		void manageSeats() throws Exception {

			mockMvc.perform(MockMvcRequestBuilders.get("/exam/manageSeats/300024").contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));

		}
	  
	  @Test
		void manageSeatsForInvalidId() throws Exception {

			mockMvc.perform(MockMvcRequestBuilders.get("/exam/manageSeats/100024").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().is4xxClientError())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
	        .andExpect(jsonPath("$.message", Matchers.is("FieldException")));


		}
	  
	
	  @Test
	  public void updateValidExamData() throws Exception {
	    ObjectMapper mapper = new ObjectMapper();
	    mapper.registerModule(new JavaTimeModule());
	    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	   
	  //  Exam exam1 = new Exam(00, LocalDate.of(1999, 5, 14), LocalTime.now(), LocalTime.now(),"", 300, "C++ Certifcation Exam" ,200);
	    Exam exam=Exam.builder()
	    		.examId(300027)
	    		.examDate(LocalDate.of(2021,7,7))
	    		.startTime(LocalTime.now())
	    		.endTime(LocalTime.now())
	    		.examName(".Net Exam")
	    		.examCost(1000)
	    		.description(".Net Certifcation Exam")
	    		.availableSeats(70)
	    		.build();
		
	    mockMvc.perform(MockMvcRequestBuilders.put("/exam/updateExamInfo")
	    .contentType(MediaType.APPLICATION_JSON)
	    .content(mapper.writeValueAsString(exam)))
	    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
	    .andExpect(status().is2xxSuccessful())
        .andExpect(jsonPath("$.examId").exists());
      
		}
	  
	  
	  @Test
	  public void updateInvalidExamData() throws Exception {
	    ObjectMapper mapper = new ObjectMapper();
	    mapper.registerModule(new JavaTimeModule());
	    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	   
	  //  Exam exam1 = new Exam(00, LocalDate.of(1999, 5, 14), LocalTime.now(), LocalTime.now(),"", 300, "C++ Certifcation Exam" ,200);
	    Exam exam=Exam.builder()
	    		.examId(300027)
	    		.examDate(LocalDate.of(2020,7,7))
	    		.startTime(LocalTime.now())
	    		.endTime(LocalTime.now())
	    		.examName("")
	    		.examCost(-100)
	    		.description(".Net Certifcation Exam")
	    		.availableSeats(70)
	    		.build();
		
	    mockMvc.perform(MockMvcRequestBuilders.put("/exam/updateExamInfo")
	    .contentType(MediaType.APPLICATION_JSON)
	    .content(mapper.writeValueAsString(exam)))
	    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
	    .andExpect(status().is4xxClientError());
       
		}
	  
	  @Test
	  public void updateInvalidExamDataForWrongId() throws Exception {
	    ObjectMapper mapper = new ObjectMapper();
	    mapper.registerModule(new JavaTimeModule());
	    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	   
	  //  Exam exam1 = new Exam(00, LocalDate.of(1999, 5, 14), LocalTime.now(), LocalTime.now(),"", 300, "C++ Certifcation Exam" ,200);
	    Exam exam=Exam.builder()
	    		.examId(100000)
	    		.examDate(LocalDate.of(2021,7,7))
	    		.startTime(LocalTime.now())
	    		.endTime(LocalTime.now())
	    		.examName("C++ Exam")
	    		.examCost(300)
	    		.description("C++ Certifcation Exam")
	    		.availableSeats(20)
	    		.build();
		
		
	    mockMvc.perform(MockMvcRequestBuilders.put("/exam/updateExamInfo")
	    .contentType(MediaType.APPLICATION_JSON)
	    .content(mapper.writeValueAsString(exam)))
	    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
	    .andExpect(status().is4xxClientError());
       
		}
	  
	  
	 
	@Test
	public void addExamTest() {
		
		Exam exam1 = new Exam(300000L, LocalDate.now(), LocalTime.now(), LocalTime.now(),"C++ Exam", 300, "C++ Certifcation Exam" ,200);

		ExamServiceImpl examService = mock(ExamServiceImpl.class);

		when(examService.addExam(exam1)).thenReturn(exam1);

		Exam exam2 = examService.addExam(exam1);

		assertEquals(exam1, exam2);

	}
	
	@Test
	public void updateExamInfoTest() {
		
		Exam exam1 = new Exam(300000L, LocalDate.now(), LocalTime.now(), LocalTime.now(),"C++ Exam", 300, "C++ Certifcation Exam",200);

		ExamServiceImpl examService = mock(ExamServiceImpl.class);
		
		examService.addExam(exam1);

		Exam exam2 = new Exam(300000L, LocalDate.now(), LocalTime.now(), LocalTime.now(),"Java Exam", 300, "Java Certifcation Exam",200);

		when(examService.updateInfo(exam2)).thenReturn(exam2);
		Exam exam3 = examService.updateInfo(exam2);
		assertEquals(exam2,exam3);

	}
	
	@Test
	void viewAllExamsTest()
	{
		

		List<Exam> exam1 = new ArrayList<>(); 
		Exam e1 = new Exam(300000L, LocalDate.now(), LocalTime.now(), LocalTime.now(),"C++ Exam", 300, "C++ Certifcation Exam",200);
		Exam e2 = new Exam(300001L, LocalDate.now(), LocalTime.now(), LocalTime.now(),"Java Exam", 1500, "Java Certifcation Exam",200);
		
		exam1.add(e1);
		exam1.add(e2);
		
		
		ExamServiceImpl service = mock(ExamServiceImpl.class);
		System.out.println(exam1);
		
		when(service.viewAllExams()).thenReturn(exam1);
		List<Exam> exam2 = service.viewAllExams();
		assertNotNull(exam2);
		assertFalse(exam2.isEmpty());
	}
	
	@Test
	public void deleteExamTest() {

		Exam e1 = new Exam(300000L, LocalDate.now(), LocalTime.now(), LocalTime.now(),"C++ Exam", 300, "C++ Certifcation Exam",200);
		Exam e2 = new Exam(300001L, LocalDate.now(), LocalTime.now(), LocalTime.now(),"Angular Exam", 300, "Angular Certifcation Exam",200);
		ExamServiceImpl examService = mock(ExamServiceImpl.class);
		
		examService.addExam(e1);
		examService.addExam(e2);
		
		List<Exam> exam1 = new ArrayList<>();
		when(examService.deleteById(300000L)).thenReturn(exam1);
		
		List<Exam> exam2 = examService.deleteById(300000L);
			assertEquals(exam1, exam2);
	}

	
	
	
	
	

}
