package com.cg.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

	@NotBlank(message = "Training Course can not be empty")
	@Size(min = 2, max = 200, message = "Enter a valid Course name")
	private String trainingCourse;

	@NotBlank(message = "Description can not be empty")
	@Size(min = 2, max = 200, message = "Enter a valid Description")
	private String description;
	
	@NotNull(message = "Cost cannot be null")
	@Min(value = 99, message = "Training Cost can't be less than 99")
	private Integer trainingCost;
	
	@NotNull(message = "Days cannot be empty")
	private Integer noOfDays;

}
