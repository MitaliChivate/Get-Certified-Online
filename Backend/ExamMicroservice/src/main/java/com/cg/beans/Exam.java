package com.cg.beans;

import java.time.LocalDate;
import java.time.LocalTime;

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

	private LocalDate examDate;

	private LocalTime startTime;
	
	private LocalTime endTime;
	
	private String examName;
	
	private Integer examCost;

	private String description;
}
