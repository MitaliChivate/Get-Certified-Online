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
import com.cg.exception.NoValueFoundException;
import com.cg.exception.NotPossibleException;
import com.cg.service.TrainingProgramInterface;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/TrainingProgram")
public class TrainingProgramController {

	@Autowired
	private TrainingProgramInterface service;

	/* 
	 * http://localhost:9300/TrainingProgram/addTrainingProgram
	 * */
	@PostMapping(value = "/addTrainingProgram")
	public TrainingProgram addTrainingProgram(@RequestBody TrainingProgram trainingProgram) {
		return this.service.addTrainingProgram(trainingProgram);
	}
	/**
	 * http://localhost:9300/TrainingProgram/deleteTrainingProgram/1
	 */
	@DeleteMapping(value = "/deleteTrainingProgram/{trainingId}")
	public Integer  deleteTrainingProgram(@PathVariable Long trainingId) {
		return service.deleteTrainingProgram(trainingId);
		
	}
	@GetMapping("/all")
	public List<TrainingProgram> getAllTrainingProgram() {//method to fetch all training program details
		
		List<TrainingProgram> trainings = this.service.GetAllTrainingProgram();
		if (trainings.isEmpty())
			throw new NotPossibleException("List of trainings not found");
		else
			return trainings;
	}
	
	@GetMapping(value ="/search/{trainingProgramId}")
	public List<TrainingProgram> searchTrainingProgram(@PathVariable long trainingProgramId) {//method to fetch training program details trainingProgram Id
		
		List<TrainingProgram> tp = this.service.searchTrainingProgramById(trainingProgramId);
		if (tp.isEmpty())
			throw new NoValueFoundException("TrainingProgram with trainingProgram Id:" + trainingProgramId + " does not exist");
		else
			return tp;
	}
	
	@GetMapping(value ="/search1/{trainingCourse}")
	public List<TrainingProgram> searchTrainingProgramByCourse(@PathVariable String trainingCourse) {//method to fetch training program details trainingCourse
		
		List<TrainingProgram> tp1 = this.service.searchTrainingProgramByCourse(trainingCourse);
		if (tp1.isEmpty())
			throw new NoValueFoundException("TrainingProgram with trainingProgram Id:" + trainingCourse + " does not exist");
		else
			return tp1;
	}

	@PutMapping("/updateTrainingProgram")
	public TrainingProgram updatetrainingProgram(@RequestBody TrainingProgram trainingProgram) {//method to update the training details
		
		return this.service.updatetrainingProgram(trainingProgram);
	}
	
}
