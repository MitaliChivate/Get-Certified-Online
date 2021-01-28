package com.cg.service;

import java.util.List;

import com.cg.beans.PaymentExam;
import com.cg.beans.PaymentTraining;
import com.cg.beans.User;

public interface PaymentService {
	
	public PaymentExam makePaymentForExam(PaymentExam payment , User user);
	
	public PaymentExam showPaymentHistory(Long paymentId);

	public List<PaymentExam> showPaymentExamHistoryByUserId(Long userId);
	
	public List<PaymentTraining> showPaymentTrainingHistoryByUserId(Long userId);

	public PaymentTraining makePaymentForTraining(PaymentTraining payment, User user);

	public int checkAlreadyEnrolledExam(Long examId);
	 
	public int checkAlreadyEnrolledTraining(Long trainingId);

	public long countPayments();

	public List<PaymentTraining> getAllTrainingPayments();

	public List<PaymentExam> getAllExamPayments();

	public int amountCollectedExam();

	public int amountCollectedTraining();

	public List<PaymentTraining>  findByTraningId(Long traningId);
}
