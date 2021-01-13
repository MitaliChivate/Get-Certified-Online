package com.cg.beans;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer paymentId;

	private String paymentMode;

	private LocalDate paymentDate;

	private Integer amount;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "COURSE_ID")
	private TrainingProgram course;

}
