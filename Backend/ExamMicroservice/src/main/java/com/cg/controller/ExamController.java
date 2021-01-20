package com.cg.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.cg.beans.Exam;

import com.cg.service.ExamService;
import com.cg.service.ExamServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import javassist.NotFoundException;
//Run Swagger http://localhost:9400/swagger-ui.html
@Api(value = "ExamController", description = "REST Apis related to Exam Entity!!!!")
//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/exam")
public class ExamController {
	
	@Autowired
	private ExamService service;
	
	private static final Logger logger = LoggerFactory.getLogger(ExamController.class);

    //"examDate": "2021-02-07", "startTime": "13:00:00",  "endTime": "15:00:00",  "examName": "C++ Exam","examCost": 300,  "description":"C++ Certifcation Exam"
	//http://localhost:9400/exam
	
	@PostMapping
	public Exam addExam(@Valid @RequestBody Exam exam) {
		logger.info("Inside addExam() method of ExamController");
		return service.addExam(exam);
			
	}
	
	//http://localhost:9400/exam
	@GetMapping
	public List<Exam> viewAllExams() {//method to fetch all exams
		logger.info("Inside viewAllExams() method of ExamController");
		return service.viewAllExams();		
	}
	
	//http://localhost:9400/exam/findbyid/3000000
	@GetMapping("/findbyid/{examId}")
	public Exam searchExamById(@PathVariable long examId) {
		logger.info("Inside searchExamById() method of ExamController");
		return service.findById(examId);

	}
	
	
	//http://localhost:9400/exam/findbyname/C++ Exam
	@GetMapping("/findbyname/{examName}")
	public List<Exam> searchExamByName(@Valid @PathVariable String examName) {
		logger.info("Inside searchExamByName() method of ExamController");
		return service.searchExamByName(examName);
		
	}
	
	//http://localhost:9400/exam/300004
	@DeleteMapping("/{examId}")
	public List<Exam> deleteExamById(@PathVariable long examId){
		logger.info("Inside deleteExamById() method of ExamController");
		return service.deleteById(examId);
		
	}
	
	//http://localhost:9400/exam/updateExamInfo
	//{"examId": 300005,"examDate": "2021-02-07", "startTime": "13:00:00",  "endTime": "15:00:00",  "examName": "C++ Exam","examCost": 300,  "description":"C++ Certifcation Exam"}
	@PutMapping("/updateExamInfo")
	public Exam updateExamInfo(@Valid @RequestBody Exam exam)
	{
		logger.info("Inside updateExamInfo() method of ExamController");
		return service.updateInfo(exam);
	}
	
	
	
	

}
