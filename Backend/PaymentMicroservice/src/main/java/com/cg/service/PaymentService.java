package com.cg.service;

import java.util.List;

import com.cg.beans.PaymentExam;
import com.cg.beans.PaymentTraining;
import com.cg.beans.User;

public interface PaymentService {
	
	public PaymentExam makePaymentForExam(PaymentExam payment , User user);
	
	public PaymentExam showPaymentHistory(Long paymentId);

	public List<PaymentExam> showPaymentHistoryByUserId(Long userId);

	public PaymentTraining makePaymentForTraining(PaymentTraining payment, User user);

}