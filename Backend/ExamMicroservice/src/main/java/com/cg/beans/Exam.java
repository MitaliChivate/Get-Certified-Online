package com.cg.beans;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "EXAM")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Exam {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exam_id_sequence")
	@SequenceGenerator(name = "exam_id_sequence", initialValue = 300000, allocationSize = 1)
	private long examId;

	@NotNull(message="Exam Date cannot be null")
	@Future(message="Past or Current Dates are not acceptable.Please Enter a Future Exam Date ")
	private LocalDate examDate;

	
	private LocalTime startTime;
	
	
	private LocalTime endTime;
	
	
	@NotBlank
	@Size(min = 2, max = 200, message = "Enter a valid Exam name")
	private String examName;
	
	
	@NotNull(message = "Cost cannot be null")
	@Min(value = 99, message = "Exam Cost can't be less than 99")
	private Integer examCost;

	@NotBlank
	@Size(min = 2, max = 200, message = "Enter a valid Description")
	private String description;
}
