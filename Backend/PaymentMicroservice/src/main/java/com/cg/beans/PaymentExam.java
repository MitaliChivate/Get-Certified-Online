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

@Entity
@Table(name = "PAYMENT_DETAILS_OF_EXAM")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentExam {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_id_sequence")
	@SequenceGenerator(name = "payment_id_sequence", initialValue = 400000, allocationSize = 1)
	private Long paymentId;

	private String paymentMode;

	private LocalDate paymentDate;

	private Integer amount;

	private Long userId;

	@ManyToOne
	@JoinColumn(name = "EXAM_ID")
	private Exam exam;

	private String cardNumber;

	private String expMonth;

	private Integer expYear;

	private Integer cvv;

}
