package com.cg.beans;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer examId;

	private LocalDate examDate;

	private LocalTime startTime;
	
	private LocalTime lastTime;
	
	private String courseName;
	
	private Integer examCost;

}
