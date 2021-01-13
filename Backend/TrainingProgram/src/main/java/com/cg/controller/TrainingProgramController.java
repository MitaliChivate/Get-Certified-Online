package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
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
	 * http://localhost:9012/TrainingProgram/addTrainingProgram 
	 * */
	@PostMapping(value = "/addTrainingProgram")
	public TrainingProgram addTrainingProgram(@RequestBody TrainingProgram trainingProgram) {
		return this.service.addTrainingProgram(trainingProgram);
	}

}
