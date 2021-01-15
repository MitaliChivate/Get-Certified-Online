package com.cg.service;

import java.util.List;

import com.cg.beans.Payment;

public interface PaymentService {
	
	public Payment makePayment(Payment payment);
	
	public List<Payment> showPaymentHistory(Long paymentId);


}
