package com.cg.service;

import java.util.List;

import com.cg.beans.TrainingProgram;

public interface TrainingProgramInterface {

	public TrainingProgram addTrainingProgram(TrainingProgram trainingProgram);

	public Integer deleteTrainingProgram(Long trainingProgramId);

	//public TrainingProgram searchTrainingProgram(Long trainingProgramId);
	public List<TrainingProgram> searchTrainingProgramById(Long trainingProgramId);
	
	public List<TrainingProgram> searchTrainingProgramByCourse(String trainingCourse);
	
	public TrainingProgram updatetrainingProgram(TrainingProgram trainingProgram);

	//public List<TrainingProgram> searchAllTrainingProgram();

	List<TrainingProgram> GetAllTrainingProgram();

}
