package com.cg.service;

import java.util.List;
import com.cg.beans.Exam;

public interface ExamService {

	Exam addExam(Exam exam);

	List<Exam> viewAllExams();

	Exam findById(long examId);

	List<Exam> searchExamByName(String examName);

	List<Exam> deleteById(long examId);

	Exam updateInfo(Exam exam);

	long countExam();

}
