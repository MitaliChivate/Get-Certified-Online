package com.cg.service;

import java.util.ArrayList;
import java.util.List;
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

		return dao.save(exam);

	}

	@Override
	public List<Exam> viewAllExams() {

		return dao.findAll();
	}

	@Override
	public Exam findById(long examId) {

		return dao.findById(examId).orElseThrow(() -> new NotFoundException("Exam ID", "Not Found"));
	}

	@Override
	public List<Exam> searchExamByName(String examName) {

		List<Exam> examList = new ArrayList<>();
		examList = dao.findAll().stream().filter(x -> x.getExamName().equals(examName)).collect(Collectors.toList());
		if (examList.isEmpty())
			throw new NotFoundException("Exam Name ", "Not Found");
		else
			return examList;
	}

	@Override
	public List<Exam> deleteById(long examId) {
		findById(examId);
		dao.deleteById(examId);
		return dao.findAll();
	}

	@Override
	public Exam updateInfo(Exam exam) {

		findById(exam.getExamId());
		return dao.save(exam);

	}

	@Override
	public long countExam() {
		return dao.count();
	}

}
