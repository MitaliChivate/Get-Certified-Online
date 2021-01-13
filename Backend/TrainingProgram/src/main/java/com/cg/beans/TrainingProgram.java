package com.cg.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
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
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "training_id_sequence")
	@SequenceGenerator(name = "training_id_sequence", initialValue = 200000, allocationSize = 1)
	private Long trainingProgramId;

	private String trainingCourse;

	private String description;
	
	private Integer trainingCost;
	
	private Integer noOfDays;

}
