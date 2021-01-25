package com.cg.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.beans.PaymentExam;
import com.cg.beans.PaymentTraining;
import com.cg.beans.User;
import com.cg.dao.PaymentDaoForExam;
import com.cg.dao.PaymentDaoForTraining;
import com.cg.exception.NoValueFoundException;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentDaoForExam paymentDao;

	@Autowired
	private PaymentDaoForTraining paymentDaoForTraining;

	@Override
	public PaymentExam makePaymentForExam(PaymentExam payment, User user) {
		String userEmail = user.getEmail();

		PaymentExam pay = this.paymentDao.save(payment);

		String firstName = user.getFirstName();

		String examName = pay.getExam().getExamName();
		
		Long paymentId=pay.getPaymentId();
		
		LocalDate payDate=pay.getPaymentDate();
		try {
			sendmail(userEmail, firstName, paymentId,payDate, examName, payment.getAmount());
		} catch (MessagingException | IOException e) {

		}
		return pay;

	}

	private void sendmail(String email, String firstName,Long paymentId,LocalDate paymentDate, String examortrainingname, Integer amount)
			throws AddressException, MessagingException, IOException {

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.googlemail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("getcertifiedonline11@gmail.com", "Getcertified@123");
			}
		});
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("getcertifiedonline11@gmail.com", false));

		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
		msg.setSubject("Get certified!!!");
		msg.setContent("<html><head>\r\n" + "<style>\r\n" + "table, th, td {\r\n" + "  border: 1px solid black;\r\n"
				+ "}\r\n" + "</style>\r\n"
				+ "</head><body><p>Hi " + firstName + ",</p><p> Your payment is successful!!</p>\r\n"
				+ "                <table style=\"border:1px solid balck;\" >\r\n" + "  <tr style=\"width:100%\">\r\n"
				+ "    <th>ReceiptNo</th>\r\n" + "    <th>PaymentDate</th> \r\n" + "    <th>PaymentAmount</th>\r\n"
				+ "    <th>Exam/Training Name</th>\r\n" + "  </tr>\r\n" + "  	<td>"+paymentId+"</td>\r\n"
				+ "    <td>"+paymentDate+"</td>\r\n" + "    <td>"+amount+"</td>\r\n"
				+ "    <td>"+examortrainingname+"</td>\r\n" + "  <tr>\r\n" + "</table><p>Thank You!</p><body><html>",
				"text/html");
		msg.setSentDate(new Date());

		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent("<html><head>\r\n" + "<style>\r\n" + "table, th, td {\r\n" + "  border: 1px solid black;\r\n"
				+ "}\r\n" + "</style>\r\n"
				+ "</head><body><p>Hi " + firstName + ",</p><p> Your payment is successful!!</p>\r\n"
				+ "                <table style=\"border:1px solid balck;\" >\r\n" + "  <tr style=\"width:100%\">\r\n"
				+ "    <th>ReceiptNo</th>\r\n" + "    <th>PaymentDate</th> \r\n" + "    <th>PaymentAmount</th>\r\n"
				+ "    <th>Exam/Training Name</th>\r\n" + "  </tr>\r\n" + "  	<td>"+paymentId+"</td>\r\n"
				+ "    <td>"+paymentDate+"</td>\r\n" + "    <td>"+amount+"</td>\r\n"
				+ "    <td>"+examortrainingname+"</td>\r\n" + "  <tr>\r\n" + "</table><p>Thank You!</p><body><html>",
				"text/html");
		Transport.send(msg);
	}

	@Override
	public PaymentExam showPaymentHistory(Long paymentId) {

		return paymentDao.findById(paymentId).orElseThrow(() -> new NoValueFoundException("Payment ID Not Found"));

	}

	@Override
	public List<PaymentExam> showPaymentHistoryByUserId(Long userId) {
		List<PaymentExam> paymentList = new ArrayList<>();
		paymentList = paymentDao.findAll().stream().filter(x -> x.getUserId().equals(userId))
				.collect(Collectors.toList());
		if (paymentList.isEmpty())
			throw new NoValueFoundException("Payment with userId:" + userId + " does not exist");
		else
			return paymentList;
	}

	@Override
	public PaymentTraining makePaymentForTraining(PaymentTraining payment, User user) {
		String userEmail = user.getEmail();

		PaymentTraining pay = this.paymentDaoForTraining.save(payment);

		String firstName = user.getFirstName();

		String courseName = pay.getTraining().getTrainingCourse();
		
Long paymentId=pay.getPaymentId();
		
		LocalDate payDate=pay.getPaymentDate();
		try {
			sendmail(userEmail, firstName, paymentId,payDate, courseName, payment.getAmount());
		}catch (MessagingException | IOException e) {

		}
		return pay;
	}

}
