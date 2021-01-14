package com.cg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.beans.Exam;
import com.cg.dao.ExamDao;
import com.cg.exception.NotFoundException;

@Service
public class ExamServiceImpl implements ExamService {

	
	@Autowired
	private ExamDao dao;
	
	@Override
	public Exam addExam(Exam exam) {
		// TODO Auto-generated method stub
		return dao.save(exam);
		
	}

	@Override
	public List<Exam> viewAllExams() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Exam findById(long examId) {
		// TODO Auto-generated method stub
		return dao.findById(examId).orElseThrow(()-> new NotFoundException("Exam ID", "Not Found"));
	}

	@Override
	public List<Exam> searchExamByName(String examName) {
		// TODO Auto-generated method stub
		List<Exam> examList=new ArrayList<>();
		examList=dao.findAll().stream().filter(x->x.getExamName().equals(examName)).collect(Collectors.toList());
		if(examList.isEmpty())
			throw new NotFoundException("Exam Name ", "Not Found");
		else
		return examList;
	}

	@Override
	public List<Exam> deleteById(long examId) {
		// TODO Auto-generated method stub
		Exam exam=findById(examId);
		dao.deleteById(examId);
		return dao.findAll();
	}

	@Override
	public Exam updateInfo(Exam exam) {
		// TODO Auto-generated method stub
		Exam examm=findById(exam.getExamId());
		return dao.save(exam);
		
	}

}
