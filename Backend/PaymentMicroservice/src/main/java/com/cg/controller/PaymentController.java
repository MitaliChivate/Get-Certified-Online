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
import com.cg.service.PaymentService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/Payment")
public class PaymentController {
	@Autowired
	private PaymentService service;

	@Autowired
	RestTemplate restTemplate;

	final String TrainingURL = "http://localhost:9300/TrainingProgram/search/";
	final String ExamURL= "http://localhost:9400/exam/findbyid/";

	
	// "http://localhost:9500/Payment/makePayment
	@PostMapping(value = "/makePayment")
	public Payment makePayment(@RequestBody PaymentDummy payDummy) {
		Payment payment=new Payment();

		int check=payDummy.getTrainingOrExam();
		Long id = payDummy.getEnrollmentId();
		if(check==0) {
		TrainingProgram tp =restTemplate.getForObject(TrainingURL+id , TrainingProgram.class);
		payment.setModeName(tp.getTrainingCourse());
		}
		else {
			Exam ex=restTemplate.getForObject(ExamURL+id, Exam.class);
			payment.setModeName(ex.getExamName());
			
		}
		payment.setPaymentMode(payDummy.getPaymentMode());
		payment.setAmount(payDummy.getAmount());
		payment.setUserId(payDummy.getUserId());
		payment.setEnrollmentId(payDummy.getEnrollmentId());
		payment.setPaymentDate(payDummy.getPaymentDate());
		
		return this.service.makePayment(payment);
		

			
	}

	@GetMapping(value = "/search/{paymentId}")
	public List<Payment> showPaymentHistory(@PathVariable long paymentId) {// method to fetch

		List<Payment> pay = this.service.showPaymentHistory(paymentId);
		return pay;
	}

}
