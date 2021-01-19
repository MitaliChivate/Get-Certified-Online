package com.cg.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.beans.Payment;
import com.cg.beans.TrainingProgram;
import com.cg.dao.PaymentDao;
import com.cg.exception.NoValueFoundException;
import com.cg.exception.NotPossibleException;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentDao paymentDao;

	@Override
	public Payment makePayment(Payment payment) {
		if (payment == null || payment.getPaymentMode() == null || payment.getPaymentDate() == null
				|| payment.getAmount() == 0 || payment.getEnrollmentId() == -1 || payment.getCardNumber() == 0
				|| payment.getCardExpDate() == null || payment.getCvv()==0)
			throw new NotPossibleException("Some of field is null");
		else
			return this.paymentDao.save(payment);
	}

	@Override
	public Payment showPaymentHistory(Long paymentId) {

		return paymentDao.findById(paymentId).orElseThrow(() -> new NoValueFoundException("Payment ID Not Found"));

		/*
		 * return this.paymentDao.findAll().stream().filter(z ->
		 * z.getPaymentId().equals(paymentId)) .collect(Collectors.toList());
		 */
	}

	@Override
	public List<Payment> showPaymentHistoryByUserId(Long userId) {
		List<Payment> paymentList = new ArrayList<>();
		paymentList = paymentDao.findAll().stream().filter(x -> x.getUserId().equals(userId))
				.collect(Collectors.toList());
		if (paymentList.isEmpty())
			throw new NoValueFoundException("Payment with userId:" + userId + " does not exist");
		else
			return paymentList;
	}

}
