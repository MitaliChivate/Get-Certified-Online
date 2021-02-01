package com.cg;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.cg.beans.Exam;
import com.cg.beans.PaymentExam;
import com.cg.beans.PaymentTraining;
import com.cg.beans.TrainingProgram;
import com.cg.beans.User;
import com.cg.service.PaymentService;
import com.cg.service.PaymentServiceImpl;

public class PaymentTest {

	// Test for exam payment
	@Test
	public void makepaymentExamTest() {

		Exam exam1 = new Exam(300000L, LocalDate.now(), LocalTime.now(), LocalTime.now(), "C++ Exam", 300,
				"C++ Certifcation Exam",200);

		User user = new User(4l, "Tejaswi", "Midgule", "Admin1", "root", "9874563210", "abc@gmail.com", "Female",
				"User", LocalDate.now());

		PaymentExam payment = new PaymentExam(11L, "Debit", LocalDate.now(), 5000, 111L, exam1, "1233456", "9", 25,
				435);

		long frontOtp = 423234l;

		PaymentService payService = mock(PaymentServiceImpl.class);

		when(payService.makePaymentForExam(payment, user, frontOtp)).thenReturn(payment);

		PaymentExam p2 = payService.makePaymentForExam(payment, user, frontOtp);

		assertEquals(payment, p2);

	}

	@Test
	void viewExamPayemntHistory() {
		List<PaymentExam> pay1 = new ArrayList<>();

		Exam exam1 = new Exam(300000L, LocalDate.now(), LocalTime.now(), LocalTime.now(), "C++ Exam", 300,
				"C++ Certifcation Exam",200);

		PaymentExam payment = new PaymentExam(11L, "Debit", LocalDate.now(), 5000, 111L, exam1, "1233456", "9", 25,
				435);

		PaymentExam payment1 = new PaymentExam(11L, "Debit", LocalDate.now(), 5000, 111L, exam1, "1233456", "9", 25,
				435);

		pay1.add(payment);

		pay1.add(payment1);

		PaymentService payService = mock(PaymentServiceImpl.class);

		when(payService.showPaymentExamHistoryByUserId(4l)).thenReturn(pay1);

		List<PaymentExam> p2 = payService.showPaymentExamHistoryByUserId(4l);

		assertNotNull(p2);
		assertFalse(p2.isEmpty());
	}

	@Test
	void viewAllExamPayments() {

		List<PaymentExam> pay1 = new ArrayList<>();

		Exam exam1 = new Exam(300000L, LocalDate.now(), LocalTime.now(), LocalTime.now(), "C++ Exam", 300,
				"C++ Certifcation Exam",200);

		PaymentExam payment = new PaymentExam(11L, "Debit", LocalDate.now(), 5000, 111L, exam1, "1233456", "9", 25,
				435);

		PaymentExam payment1 = new PaymentExam(11L, "Debit", LocalDate.now(), 5000, 111L, exam1, "1233456", "9", 25,
				435);

		pay1.add(payment);

		pay1.add(payment1);

		PaymentService payService = mock(PaymentServiceImpl.class);

		when(payService.getAllExamPayments()).thenReturn(pay1);

		List<PaymentExam> pay2 = payService.getAllExamPayments();

		assertNotNull(pay2);
		assertFalse(pay2.isEmpty());
	}

	// Test for training payment
	@Test
	public void makepaymentTrainingTest() {

		TrainingProgram trainingProgram1 = new TrainingProgram(200001L, "Java", "Programming Language", 2000, 60);

		User user = new User(4l, "Tejaswi", "Midgule", "Admin1", "root", "9874563210", "abc@gmail.com", "Female",
				"User", LocalDate.now());

		PaymentTraining payment = new PaymentTraining(11L, "Debit", LocalDate.now(), 5000, 111L, trainingProgram1,
				"1233456", "9", 25, 435);

		long frontOtp = 423234l;

		PaymentService payService = mock(PaymentServiceImpl.class);

		when(payService.makePaymentForTraining(payment, user, frontOtp)).thenReturn(payment);

		PaymentTraining p2 = payService.makePaymentForTraining(payment, user, frontOtp);

		assertEquals(payment, p2);

	}

	@Test
	void viewTrainingPayemntHistory() {
		List<PaymentTraining> pay1 = new ArrayList<>();

		TrainingProgram trainingProgram1 = new TrainingProgram(200001L, "Java", "Programming Language", 2000, 60);

		PaymentTraining payment = new PaymentTraining(11L, "Debit", LocalDate.now(), 5000, 111L, trainingProgram1,
				"1233456", "9", 25, 435);

		PaymentTraining payment1 = new PaymentTraining(11L, "Debit", LocalDate.now(), 5000, 111L, trainingProgram1,
				"1233456", "9", 25, 435);

		pay1.add(payment);

		pay1.add(payment1);

		PaymentService payService = mock(PaymentServiceImpl.class);

		when(payService.showPaymentTrainingHistoryByUserId(4l)).thenReturn(pay1);

		List<PaymentTraining> p2 = payService.showPaymentTrainingHistoryByUserId(4l);

		assertNotNull(p2);
		assertFalse(p2.isEmpty());
	}

	@Test
	void viewAllTrainingPayments() {

		List<PaymentTraining> pay1 = new ArrayList<>();

		TrainingProgram trainingProgram1 = new TrainingProgram(200001L, "Java", "Programming Language", 2000, 60);

		PaymentTraining payment = new PaymentTraining(11L, "Debit", LocalDate.now(), 5000, 111L, trainingProgram1,
				"1233456", "9", 25, 435);

		PaymentTraining payment1 = new PaymentTraining(11L, "Debit", LocalDate.now(), 5000, 111L, trainingProgram1,
				"1233456", "9", 25, 435);

		pay1.add(payment);

		pay1.add(payment1);

		PaymentService payService = mock(PaymentServiceImpl.class);

		when(payService.getAllTrainingPayments()).thenReturn(pay1);

		List<PaymentTraining> pay2 = payService.getAllTrainingPayments();

		assertNotNull(pay2);
		assertFalse(pay2.isEmpty());
	}

}
