package com.cg.beans;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PAYMENT_DETAILS_OF_TRAINING")
public class PaymentTraining {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_id_sequence")
	@SequenceGenerator(name = "payment_id_sequence", initialValue = 500000, allocationSize = 1)
	private Long paymentId;

	private String paymentMode;

	private LocalDate paymentDate; 

	private Integer amount;

	private Long userId;

	@ManyToOne
	@JoinColumn(name = "TRAINING_ID")
	private TrainingProgram training;

	private String cardNumber;

	private String expMonth;
	
	private Integer expYear;

	private Integer cvv; 

}
