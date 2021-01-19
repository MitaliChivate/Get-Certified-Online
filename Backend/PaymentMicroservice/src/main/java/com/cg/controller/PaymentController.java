package com.cg.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.beans.Exam;
import com.cg.beans.Payment;
import com.cg.beans.PaymentDummy;
import com.cg.beans.TrainingProgram;
import com.cg.beans.User;
import com.cg.exception.NotPossibleException;
import com.cg.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//Run Swagger http://localhost:9500/swagger-ui.html
@Api(value = "PaymentController", description = "REST Apis related to Payment Entity!!!!")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/Payment")
public class PaymentController {
	@Autowired
	private PaymentService service;

	@Autowired
	RestTemplate restTemplate;

	final String TrainingURL = "http://localhost:9300/TrainingProgram/searchTrainingProgramById/";
	final String ExamURL = "http://localhost:9400/exam/findbyid/";
	final String UserURL = "http://localhost:9200/user/searchUser/";

	private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);

	/*
	 * "paymentMode" : "Debit", "paymentDate" : "2021-02-07", "amount":"500",
	 * "userId" : 100000, "enrollmentId" : 200001, "trainingOrExam" : 0,
	 * "cardNumber":123456789, "cardExpDate":"09/25", "cvv":"234"
	 */
	// "http://localhost:9500/Payment/makePayment
	@PostMapping(value = "/makePayment")
	public Payment makePayment(@RequestBody PaymentDummy payDummy)
			throws AddressException, MessagingException, IOException {
		logger.info("Inside makePayment() method of PaymentController");
		Payment payment = new Payment();

		int check = payDummy.getTrainingOrExam();
		Long id = payDummy.getEnrollmentId();
		if (check == 0) {
			TrainingProgram tp = restTemplate.getForObject(TrainingURL + id, TrainingProgram.class);
			payment.setModeName(tp.getTrainingCourse());
		} else {
			Exam ex = restTemplate.getForObject(ExamURL + id, Exam.class);
			payment.setModeName(ex.getExamName());
			System.out.println(ex);

		}
		payment.setPaymentMode(payDummy.getPaymentMode());
		payment.setAmount(payDummy.getAmount());
		payment.setUserId(payDummy.getUserId());
		payment.setEnrollmentId(payDummy.getEnrollmentId());
		payment.setPaymentDate(payDummy.getPaymentDate());
		payment.setCardNumber(payDummy.getCardNumber());
		payment.setCardExpDate(payDummy.getCardExpDate());
		payment.setCvv(payDummy.getCvv());

		long userId = payDummy.getUserId();
		User user = restTemplate.getForObject(UserURL + userId, User.class);
		String userEmail = user.getEmail();
		sendmail(userEmail, payDummy.getAmount());
		return this.service.makePayment(payment);

	}

	private void sendmail(String email, Integer amount) throws AddressException, MessagingException, IOException {

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
		msg.setContent("Your payment is successful!!\n Amount paid for get certified online is " + amount, "text/html");
		msg.setSentDate(new Date());

		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent("Your payment is successful!!\\n Amount paid for get certified online is " + amount,
				"text/html");
//		   Multipart multipart = new MimeMultipart();
//		   multipart.addBodyPart(messageBodyPart);
//		   MimeBodyPart attachPart = new MimeBodyPart();

		// attachPart.attachFile("/var/tmp/image19.png");
		// multipart.addBodyPart(attachPart);
		// msg.setContent(multipart);
		Transport.send(msg);
	}

	// http://localhost:9500/Payment/search/1000
	@GetMapping(value = "/search/{paymentId}")
	public Payment showPaymentHistory(@PathVariable long paymentId) {// method to fetch
		logger.info("Inside showPaymentHistory() method of PaymentController");
		/*
		 * List<Payment> pay = this.service.showPaymentHistory(paymentId); return pay;
		 */
		return service.showPaymentHistory(paymentId);
	}

	// http://localhost:9500/Payment/searchByUserId/11
	@GetMapping(value = "/searchByUserId/{userId}")
	public List<Payment> showPaymentHistoryByUserId(@PathVariable long userId) {
		logger.info("Inside showPaymentHistoryByUserId() method of PaymentController");
		return service.showPaymentHistoryByUserId(userId);
	}

}
