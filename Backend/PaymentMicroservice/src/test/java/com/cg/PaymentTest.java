package com.cg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.cg.beans.Payment;
import com.cg.service.PaymentService;
import com.cg.service.PaymentServiceImpl;

public class PaymentTest {

	@Test
	void testMakePayment() {

		Payment payment = new Payment(11L, "Debit", LocalDate.now(), 5000, 111L, "Exam", 200000L, 1233456, "9/25", 435);
		PaymentService payService = mock(PaymentServiceImpl.class);
		when(payService.makePayment(payment)).thenReturn(payment);

		Payment p2 = payService.makePayment(payment);
		assertEquals(payment, p2);

	}

	@Test
	public void viewPaymentHistory() {

		Payment payment = new Payment(11L, "Debit", LocalDate.now(), 5000, 111L, "Exam", 200000L, 1233456, "9/25", 435);
		PaymentService payService = mock(PaymentServiceImpl.class);
		payService.makePayment(payment);
		when(payService.showPaymentHistory(11L)).thenReturn(payment);

		Payment p2 = payService.showPaymentHistory(11L);
		assertEquals(payment, p2);
	}

	@Test
	public void viewPaymentHistoryByUserId() {
		List<Payment> pay1 = new ArrayList<>();
		Payment payment = new Payment(11L, "Debit", LocalDate.now(), 5000, 111L, "Exam", 200000L, 1233456, "9/25", 435);
		Payment payment1 = new Payment(12L, "Debit", LocalDate.now(), 5000, 111L, "Exam", 200001L, 1233457, "9/25",
				436);
		pay1.add(payment1);
		pay1.add(payment);
		PaymentService payService = mock(PaymentServiceImpl.class);
		when(payService.showPaymentHistoryByUserId(111L)).thenReturn(pay1);

		List<Payment> p2 = payService.showPaymentHistoryByUserId(111L);
		assertNotNull(p2);
		assertFalse(p2.isEmpty());
	}

}
