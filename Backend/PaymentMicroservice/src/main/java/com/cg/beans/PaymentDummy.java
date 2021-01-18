package com.cg.beans;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDummy {

	
	private long paymentId;

	private String paymentMode;

	private LocalDate paymentDate;

	private Integer amount;

	private Long userId;

	private Long enrollmentId; // exam id or course id

	private int trainingOrExam; // 0 for course else for exam(1)
	
	
}
