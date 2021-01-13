package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.beans.TrainingProgram;
import com.cg.dao.TrainingProgramDao;
import com.cg.exception.NotPossibleException;

@Service
public class TrainingProgramImpl implements TrainingProgramInterface {

	@Autowired
	private TrainingProgramDao trainingDao;

	@Override
	public TrainingProgram addTrainingProgram(TrainingProgram trainingProgram) {

		if (trainingProgram==null || trainingProgram.getTrainingCourse()==null||trainingProgram.getDescription()==null ||trainingProgram.getNoOfDays()==0)
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
	public TrainingProgramInterface searchTrainingProgram(Integer trainingProgramId) {

		return null;
	}

	@Override
	public List<TrainingProgramInterface> searchAllTrainingProgram() {

		return null;
	}

}
