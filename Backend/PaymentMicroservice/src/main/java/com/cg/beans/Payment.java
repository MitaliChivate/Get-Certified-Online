package com.cg.beans;

import java.time.LocalDate;

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
@Table(name = "PAYMENT_DETAILS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_id_sequence")
	@SequenceGenerator(name = "payment_id_sequence", initialValue = 400000, allocationSize = 1)
	private long paymentId;

	private String paymentMode;

	private LocalDate paymentDate;

	private Integer amount;
	
	private int userId;
	
//	@ManyToOne
//	@JoinColumn(name = "COURSE_ID")
//	private TrainingProgram course;
//	
//	@ManyToOne
//	@JoinColumn(name = "EXAM_ID")
//	private TrainingProgram examId;
	
	private int enrollmentId;
	
	private int trainingOrExam; //0 for exam, -1 for training  

}
