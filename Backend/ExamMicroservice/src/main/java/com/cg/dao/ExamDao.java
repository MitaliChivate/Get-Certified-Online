package com.cg.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.beans.Exam;

@Repository
public interface ExamDao extends JpaRepository<Exam, Long> {

	
}
