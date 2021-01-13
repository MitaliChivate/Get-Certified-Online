package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.beans.TrainingProgram;

@Repository
public interface TrainingProgramDao  extends JpaRepository<TrainingProgram, Integer>  {

}
