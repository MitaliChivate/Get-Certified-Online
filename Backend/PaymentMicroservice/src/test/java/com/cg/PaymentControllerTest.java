package com.cg;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cg.beans.Exam;
import com.cg.beans.PaymentExam;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PaymentControllerTest {

	@Autowired
	private WebApplicationContext wc;

	@Autowired
	private MockMvc mockMvc;

	@Mock
	PaymentExam paymentExam;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wc).build();
	}

	@Test
	void testSearchTrainingPaymentByIdSuccess() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/Payment/searchTrainingPaymentByUserId/100005")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));

	}

	@Test
	void testSearchTrainingPaymentByIdFailure() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/Payment/searchTrainingPaymentByUserId/100004")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));

	}

	@Test
	void testSearchExamPaymentByIdSuccess() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/Payment//searchPaymentExamHistoryByUserId/100004")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));

	}

	@Test
	void testSearchExamPaymentByIdFailure() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/Payment/searchPaymentExamHistoryByUserId/100000")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));

	}

	@Test
	void testSearchAllExamPaymentByIdSuccess() throws Exception {

		mockMvc.perform(
				MockMvcRequestBuilders.get("/Payment/getAllExamPayments").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));

	}

	@Test
	void testSearchAllTrainingPaymentByIdSuccess() throws Exception {

		mockMvc.perform(
				MockMvcRequestBuilders.get("/Payment/getAllTrainingPayments").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));

	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	void testMakeExamPaymentFailure() throws Exception {

		ObjectMapper mapper = new ObjectMapper();

		Exam exam1 = new Exam(300000L, LocalDate.now(), LocalTime.now(), LocalTime.now(), "C++ Exam", 300,
				"C++ Certifcation Exam", 200);

		PaymentExam payment = new PaymentExam(11L, "Debit", LocalDate.now(), 5000, 111L, exam1, "1233456", "9", 25,
				435);

		long frontOtp = 423123l;
		;

		mockMvc.perform(MockMvcRequestBuilders.post("/Payment/makePaymentForExam/423254")
				.contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(payment)))
				.andExpect(status().isBadRequest());

	}

	@Test
	void testAmountCollectedForTraining() throws Exception {

		mockMvc.perform(
				MockMvcRequestBuilders.get("/Payment/getAmountTraining").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));

	}

	@Test
	void testAmountCollectedForExam() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/Payment/getAmountExam").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));

	}

	@Test
	void testALlExamPayments() throws Exception {

		mockMvc.perform(
				MockMvcRequestBuilders.get("/Payment/getAllExamPayments").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));

	}

	@Test
	void testALlTrainingPayments() throws Exception {

		mockMvc.perform(
				MockMvcRequestBuilders.get("/Payment/getAllTrainingPayments").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));

	}

	@Test
	void testGetPaymentCount() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/Payment/count").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));

	}

	@Test
	void testGenerateOtpSuccess() throws Exception {

		mockMvc.perform(
				MockMvcRequestBuilders.get("/Payment/generateOtp/100005").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));

	}

	@Test
	void testCheckSeatsForExamSuccess() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/Payment/checkAvailableSeats/300000")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	void testFindTrainingById() throws Exception {

		mockMvc.perform(
				MockMvcRequestBuilders.get("/Payment/findByTrainingId/200000").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));

	}

	@Test
	void checkEnrolledExams() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/Payment/checkExamEnrolled/200009/100000")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));

	}

	@Test
	void checkEnrolledTraining() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/Payment/checkTrainingEnrolled/300000/100000")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));

	}

}
