package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.beans.Exam;
import com.cg.beans.User;
import com.cg.exception.NotFoundException;
import com.cg.service.ExamService;
import io.swagger.annotations.Api;

@Api(value = "ExamController", description = "REST Apis related to Exam Entity!!!!")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/exam")
public class ExamController {

	@Autowired
	RestTemplate restTemplate;

	final String UserURL = "http://localhost:9200/user/searchUser/";

	@Autowired
	private ExamService service;

	// "examDate": "2021-02-07", "startTime": "13:00:00", "endTime": "15:00:00",
	// "examName": "C++ Exam","examCost": 300, "description":"C++ Certifcation Exam"
	// http://localhost:9400/exam/addExams

	@PostMapping("/addExams")
	public Exam addExam(@RequestBody Exam exam) {

		return service.addExam(exam);

	}

	// http://localhost:9400/exam/getAllExams
	@GetMapping("/getAllExams")
	public List<Exam> viewAllExams() {// method to fetch all exams

		return service.viewAllExams();
	}

	// http://localhost:9400/exam/findByExamId/3000000
	@GetMapping("/findByExamId/{examId}")
	public Exam searchExamById(@PathVariable long examId) {

		return service.findById(examId);

	}

	// http://localhost:9400/exam/findByExamName/C++ Exam
	@GetMapping("/findByExamName/{examName}")
	public List<Exam> searchExamByName(@PathVariable String examName) {
		return service.searchExamByName(examName);

	}

	// http://localhost:9400/exam/deleteExam/300004
	@DeleteMapping("/deleteExam/{examId}")
	public List<Exam> deleteExamById(@PathVariable long examId) {

		return service.deleteById(examId);

	}

	// http://localhost:9400/exam/updateExamInfo
	// {"examId": 300005,"examDate": "2021-02-07", "startTime": "13:00:00",
	// "endTime": "15:00:00", "examName": "C++ Exam","examCost": 300,
	// "description":"C++ Certifcation Exam"}
	@PutMapping("/updateExamInfo")
	public Exam updateExamInfo(@RequestBody Exam exam) {
		return service.updateInfo(exam);
	}

	// http://localhost:9400/exam/count
	@GetMapping("/count")
	public long countExams() {
		return this.service.countExam();

	}
	
	// http://localhost:9400/exam/sendReminder/100000
	@PostMapping(value = "/sendReminder/{userId}")
	public void sendReminder(@RequestBody Exam exam, @PathVariable Long userId) {
		
		User user = restTemplate.getForObject(UserURL + userId, User.class);
		/*
		 * if (userId == null) throw new NotFoundException("User", " Not Found");
		 */
		
		this.service.sendReminder(exam, user);

	}

}
