package com.cg;
import org.junit.jupiter.api.Test;

import com.cg.beans.Exam;

import com.cg.service.ExamServiceImpl;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class ExamTests {
	
	@Test
	public void addExamTest() {
		
		Exam exam1 = new Exam(300000L, LocalDate.now(), LocalTime.now(), LocalTime.now(),"C++ Exam", 300, "C++ Certifcation Exam");

		ExamServiceImpl examService = mock(ExamServiceImpl.class);

		when(examService.addExam(exam1)).thenReturn(exam1);

		Exam exam2 = examService.addExam(exam1);

		assertEquals(exam1, exam2);

	}
	
	@Test
	public void updateExamInfoTest() {
		
		Exam exam1 = new Exam(300000L, LocalDate.now(), LocalTime.now(), LocalTime.now(),"C++ Exam", 300, "C++ Certifcation Exam");

		ExamServiceImpl examService = mock(ExamServiceImpl.class);
		
		examService.addExam(exam1);

		Exam exam2 = new Exam(300000L, LocalDate.now(), LocalTime.now(), LocalTime.now(),"Java Exam", 300, "Java Certifcation Exam");

		when(examService.updateInfo(exam2)).thenReturn(exam2);
		Exam exam3 = examService.updateInfo(exam2);
		assertEquals(exam2,exam3);

	}
	
	@Test
	void viewAllExamsTest()
	{
		

		List<Exam> exam1 = new ArrayList<>(); 
		Exam e1 = new Exam(300000L, LocalDate.now(), LocalTime.now(), LocalTime.now(),"C++ Exam", 300, "C++ Certifcation Exam");
		Exam e2 = new Exam(300001L, LocalDate.now(), LocalTime.now(), LocalTime.now(),"Java Exam", 1500, "Java Certifcation Exam");
		
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

		Exam e1 = new Exam(300000L, LocalDate.now(), LocalTime.now(), LocalTime.now(),"C++ Exam", 300, "C++ Certifcation Exam");
		Exam e2 = new Exam(300001L, LocalDate.now(), LocalTime.now(), LocalTime.now(),"Angular Exam", 300, "Angular Certifcation Exam");
		ExamServiceImpl examService = mock(ExamServiceImpl.class);
		
		examService.addExam(e1);
		examService.addExam(e2);
		
		List<Exam> exam1 = new ArrayList<>();
		when(examService.deleteById(300000L)).thenReturn(exam1);
		
		List<Exam> exam2 = examService.deleteById(300000L);
			assertEquals(exam1, exam2);
	}

	
	
	

}
