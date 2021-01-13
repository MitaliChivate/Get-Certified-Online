package com.cg.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TRAINING_PROGRAM")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrainingProgram {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer trainingProgramId;

	private String courseName;

	private String description;
	
	private Integer trainingCost;
	
	private Integer noOfDays;

}
