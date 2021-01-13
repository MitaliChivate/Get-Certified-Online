package com.cg.service;

import java.util.List;

import com.cg.beans.TrainingProgram;

public interface TrainingProgramInterface {

	public TrainingProgram addTrainingProgram(TrainingProgram trainingProgram);

	public void deleteTrainingProgram(Integer trainingProgramId);

	public TrainingProgramInterface searchTrainingProgram(Integer trainingProgramId);

	public List<TrainingProgramInterface> searchAllTrainingProgram();

}
