package com.cg.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.beans.PaymentExam;
import com.cg.beans.PaymentTraining;
import com.cg.beans.User;
import com.cg.exception.NoValueFoundException;
import com.cg.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.swagger.annotations.Api;

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

	// http://localhost:9500/Payment/makePaymentForExam
	@PostMapping(value = "/makePaymentForExam/{frontOtp}")
	public PaymentExam makePaymentForExam(@RequestBody PaymentExam payment, @PathVariable long frontOtp) {

		long userId = payment.getUserId();

		User user = restTemplate.getForObject(UserURL + userId, User.class);
		if (user == null)
			throw new NoValueFoundException("User Not Found");
		System.out.println(payment);
		payment.setPaymentDate(LocalDate.now());
		return this.service.makePaymentForExam(payment, user, frontOtp);

	}

	// http://localhost:9500/Payment/makePaymentForTraining
	@PostMapping(value = "/makePaymentForTraining/{frontOtp}")
	public PaymentTraining makePaymentForTaining(@RequestBody PaymentTraining payment, @PathVariable long frontOtp) {

		long userId = payment.getUserId();

		User user = restTemplate.getForObject(UserURL + userId, User.class);
		if (user == null)
			throw new NoValueFoundException("User Not Found");
		payment.setPaymentDate(LocalDate.now());
		return this.service.makePaymentForTraining(payment, user, frontOtp);

	}

	// http://localhost:9500/Payment/search/1000
	@GetMapping(value = "/search/{paymentId}")
	public PaymentExam showPaymentHistory(@PathVariable long paymentId) {// method to fetch
		logger.info("Inside showPaymentHistory() method of PaymentController");
		return service.showPaymentHistory(paymentId);
	}

	// http://localhost:9500/Payment/searchPaymentExamHistoryByUserId/11
	@GetMapping(value = "/searchPaymentExamHistoryByUserId/{userId}")
	public List<PaymentExam> showPaymentExamHistoryByUserId(@PathVariable long userId) {
		logger.info("Inside showPaymentExamHistoryByUserId() method of PaymentController");
		return service.showPaymentExamHistoryByUserId(userId);
	}

	// http://localhost:9500/Payment/checkExamEnrolled/{examId}/{userId}
	@GetMapping(value = "/checkExamEnrolled/{examId}/{userId}")
	public int checkExam(@PathVariable Long examId, @PathVariable Long userId) {

		return this.service.checkAlreadyEnrolledExam(examId , userId);
	}

	// http://localhost:9500/Payment/checkTrainingEnrolled/{trainingId}/{userId}
	@GetMapping(value = "/checkTrainingEnrolled/{trainingId}/{userId}")
	public int checkTraining(@PathVariable Long trainingId, @PathVariable Long userId) {

		return this.service.checkAlreadyEnrolledTraining(trainingId , userId);
	}

	// http://localhost:9500/Payment/searchTrainingPaymentByUserId/11
	@GetMapping(value = "/searchTrainingPaymentByUserId/{userId}")
	public List<PaymentTraining> showPaymentTrainingHistoryByUserId(@PathVariable long userId) {
		// logger.info("Inside showPaymentTrainingHistoryByUserId() method of
		// PaymentController");
		return service.showPaymentTrainingHistoryByUserId(userId);
	}

	// http://localhost:9500/Payment/count
	@GetMapping(value = "/count")
	public long count() {
		return this.service.countPayments();

	}

	// http://localhost:9500/Payment/getAllTrainingPayments
	@GetMapping(value = "/getAllTrainingPayments")
	public List<PaymentTraining> getAllTrainingsPayment() {
		return this.service.getAllTrainingPayments();

	}

	// http://localhost:9500/Payment/getAllExamPayments
	@GetMapping(value = "/getAllExamPayments")
	public List<PaymentExam> getAllExamsPayment() {
		return this.service.getAllExamPayments();

	}

	// http://localhost:9500/Payment/getAmountExam
	@GetMapping(value = "/getAmountExam")
	public int getTotalAmountCollectedOfExam() {
		return this.service.amountCollectedExam();

	}

	// http://localhost:9500/Payment/getAmountTraining
	@GetMapping(value = "/getAmountTraining")
	public int getTotalAmountCollectedOfTraining() {
		return this.service.amountCollectedTraining();

	}

	// http://localhost:9500/Payment/findByTrainingId
	@GetMapping(value = "/findByTrainingId/{trainingId}")
	public List<PaymentTraining> findByTrainingId(@PathVariable Long trainingId) {

		return this.service.findByTraningId(trainingId);

	}

	// http://localhost:9500/Payment/generateOtp
	@GetMapping(value = "/generateOtp/{userId}")
	public long generateOtp(@PathVariable Long userId) {

		User user = restTemplate.getForObject(UserURL + userId, User.class);
		if (user == null)
			throw new NoValueFoundException("User Not Found");

		return this.service.generateOtpForExam(user.getEmail());

	}

}
