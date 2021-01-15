package com.cg.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.beans.Payment;
import com.cg.dao.PaymentDao;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentDao paymentDao;

	@Override
	public Payment makePayment(Payment payment) {
		return this.paymentDao.save(payment);
	}

	@Override
	public List<Payment> showPaymentHistory(Long paymentId) {

        
        return this.paymentDao.findAll().stream().filter(z->z.getPaymentId().equals(paymentId)).collect(Collectors.toList());
	}

}
