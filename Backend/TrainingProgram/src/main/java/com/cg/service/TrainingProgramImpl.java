package com.cg.service;

import java.util.List;
import java.util.stream.Collectors;

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

	/*
	 * @Override public TrainingProgram searchTrainingProgram(Long
	 * trainingProgramId) {
	 * 
	 * return this.trainingDao.findAll().stream().filter(x->x.getTrainingProgramId()
	 * == trainingProgramId).findAny().get();
	 * 
	 * }
	 */


	@Override
	public List<TrainingProgram> GetAllTrainingProgram() {

		return this.trainingDao.findAll();
	}

	@Override
	public TrainingProgram updatetrainingProgram(TrainingProgram trainingProgram) {
		// TODO Auto-generated method stub
		return this.trainingDao.save(trainingProgram);
	}

	@Override
	public List<TrainingProgram> searchTrainingProgramById(Long trainingProgramId) {
		
			return this.trainingDao.findAll().stream().filter(x->x.getTrainingProgramId().equals(trainingProgramId)).collect(Collectors.toList());
		}

	@Override
	public List<TrainingProgram> searchTrainingProgramByCourse(String trainingCourse) {
		// TODO Auto-generated method stub
	 return this.trainingDao.findAll().stream().filter(x->x.getTrainingCourse().equals(trainingCourse)).collect(Collectors.toList());
	}

}
