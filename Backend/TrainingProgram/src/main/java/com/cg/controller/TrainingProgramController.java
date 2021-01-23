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

import com.cg.beans.TrainingProgram;
import com.cg.service.TrainingProgramInterface;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/TrainingProgram")
public class TrainingProgramController {

	@Autowired
	private TrainingProgramInterface service;

	/*
	 * http://localhost:9300/TrainingProgram/addTrainingProgram 
	 * "trainingCourse"
	 * :"Java","description" : "Programming Language","trainingCost" :
	 * 2000,"noOfDays" : 60
	 */
	@PostMapping(value = "/addTrainingProgram")
	public TrainingProgram addTrainingProgram(@RequestBody TrainingProgram trainingProgram) {
		return this.service.addTrainingProgram(trainingProgram);
	}

	/**
	 * http://localhost:9300/TrainingProgram/deleteTrainingProgram/1
	 */
	@DeleteMapping(value = "/deleteTrainingProgram/{trainingId}")
	public Integer deleteTrainingProgram(@PathVariable Long trainingId) {
		return service.deleteTrainingProgram(trainingId);

	}

	/**
	 * http://localhost:9300/TrainingProgram/searchAllTrainingProgram
	 */

	@GetMapping("/searchAllTrainingProgram")
	public List<TrainingProgram> getAllTrainingProgram() {// method to fetch all training program details
		return service.GetAllTrainingProgram();
	}

	/**
	 * http://localhost:9300/TrainingProgram/searchTrainingProgramById/200001
	 */
	@GetMapping(value = "/searchTrainingProgramById/{trainingProgramId}")
	public TrainingProgram searchTrainingProgram(@PathVariable long trainingProgramId) {

		return service.searchTrainingProgramById(trainingProgramId);
	}

	/**
	 */
	@GetMapping(value = "/searchTrainingProgramByCourse/{trainingCourse}")
	public List<TrainingProgram> searchTrainingProgramByCourse(@PathVariable String trainingCourse) {

		return service.searchTrainingProgramByCourse(trainingCourse);
	}

	/**
	 * http://localhost:9300/TrainingProgram/updateTrainingProgram
	 * "trainingProgramId": 200001,"trainingCourse" :"Python", "description" :
	 * "Programming Language", "trainingCost" : 2000,"noOfDays" : 60
	 */

	@PutMapping("/updateTrainingProgram")
	public TrainingProgram updatetrainingProgram(@RequestBody TrainingProgram trainingProgram) {// method to update the
																								// training details

		return this.service.updatetrainingProgram(trainingProgram);
	}

	/***
	 * 
	 *  http://localhost:9300/TrainingProgram/count
	 */
	@GetMapping("/count")
	public long countExams() {
		return this.service.countTraining();

	}
}
