package com.cg.controller;

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

import com.cg.beans.Exam;
import com.cg.beans.Payment;
import com.cg.beans.PaymentDummy;
import com.cg.beans.TrainingProgram;
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

	private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);
	
	/* "paymentMode" : "Debit","paymentDate" : "2021-02-07","amount" : 5000,"userId" : 11,"enrollmentId" : 300000,"trainingOrExam" : 1
*/
	// "http://localhost:9500/Payment/makePayment
	@PostMapping(value = "/makePayment")
	public Payment makePayment(@RequestBody PaymentDummy payDummy) {
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

		return this.service.makePayment(payment);

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
