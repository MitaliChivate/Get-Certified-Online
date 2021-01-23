package com.cg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.beans.TrainingProgram;
import com.cg.dao.TrainingProgramDao;
import com.cg.exception.NoValueFoundException;
import com.cg.exception.NotPossibleException;

@Service
public class TrainingProgramImpl implements TrainingProgramInterface {

	@Autowired
	private TrainingProgramDao trainingDao;

	@Override
	public TrainingProgram addTrainingProgram(TrainingProgram trainingProgram) {

		if (trainingProgram == null || trainingProgram.getTrainingCourse() == null
				|| trainingProgram.getDescription() == null || trainingProgram.getNoOfDays() == 0)
			throw new NotPossibleException("Some of field is null");
		else
			return this.trainingDao.save(trainingProgram);

	}

	@Override
	public Integer deleteTrainingProgram(Long trainingProgramId) {
		try {
			this.trainingDao.deleteById(trainingProgramId);
		} catch (Exception e) {
			return -1;
		}

		return 1;

	}

	@Override
	public List<TrainingProgram> GetAllTrainingProgram() {

		List<TrainingProgram> trainingList = new ArrayList<>();
		trainingList = trainingDao.findAll();
		if (trainingList.isEmpty())
			throw new NoValueFoundException("List of trainings not found");
		else
			return trainingList;
	}

	@Override
	public TrainingProgram updatetrainingProgram(TrainingProgram trainingProgram) {
		searchTrainingProgramById(trainingProgram.getTrainingProgramId());
		return this.trainingDao.save(trainingProgram);
	}

	@Override
	public TrainingProgram searchTrainingProgramById(Long trainingProgramId) {

		return trainingDao.findById(trainingProgramId)
				.orElseThrow(() -> new NoValueFoundException("Training ID Not Found"));

	}

	@Override
	public List<TrainingProgram> searchTrainingProgramByCourse(String trainingCourse) {
		List<TrainingProgram> trainingList = new ArrayList<>();
		trainingList = trainingDao.findAll().stream().filter(x -> x.getTrainingCourse().equals(trainingCourse))
				.collect(Collectors.toList());
		if (trainingList.isEmpty())
			throw new NoValueFoundException(
					"TrainingProgram with trainingCourse:" + trainingCourse + " does not exist");
		else
			return trainingList;
	}

	@Override
	public long countTraining() {

		return this.trainingDao.count();
	}

}
