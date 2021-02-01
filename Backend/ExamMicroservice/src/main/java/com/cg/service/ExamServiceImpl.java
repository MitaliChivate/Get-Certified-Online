package com.cg.service;

import java.io.IOException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

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
import org.springframework.stereotype.Service;

import com.cg.beans.Exam;
import com.cg.beans.User;
import com.cg.dao.ExamDao;
import com.cg.exception.NotFoundException;

@Service
public class ExamServiceImpl implements ExamService {

	@Autowired
	private ExamDao dao;

	@Override
	public Exam addExam(Exam exam) {

		return dao.save(exam);

	}

	@Override
	public List<Exam> viewAllExams() {

		return dao.findAll();
	}

	@Override
	public Exam findById(long examId) {

		return dao.findById(examId).orElseThrow(() -> new NotFoundException("Exam ID", "Not Found"));
	}

	@Override
	public List<Exam> searchExamByName(String examName) {

		List<Exam> examList = new ArrayList<>();
		examList = dao.findAll().stream().filter(x -> x.getExamName().equals(examName)).collect(Collectors.toList());
		if (examList.isEmpty())
			throw new NotFoundException("Exam Name ", "Not Found");
		else
			return examList;
	}

	@Override
	public List<Exam> deleteById(long examId) {
		findById(examId);
		dao.deleteById(examId);
		return dao.findAll();
	}

	@Override
	public Exam updateInfo(Exam exam) {

		findById(exam.getExamId());
		return dao.save(exam);

	}


	@Override
	public long countExam() {
		return dao.count();
	}

	private void sendmail(String email, String firstName, String examName, LocalDate examDate, LocalTime startTime,
			LocalTime endTime) throws AddressException, MessagingException, IOException {

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
				+ "}\r\n" + "</style>\r\n" + "</head><body><p>Hi " + firstName
				+ ",</p><p> Reminder for your exam !!</p>\r\n"
				+ "                <table style=\"border:1px solid balck;\" >\r\n" + "  <tr style=\"width:100%\">\r\n"
				+ "    <th>Exam Name</th>\r\n" + "    <th>Exam Date</th> \r\n" + "    <th>Start Time</th>\r\n"
				+ "    <th>End Time</th>\r\n" + "  </tr>\r\n" + "  	<td>" + examName + "</td>\r\n"
				+ "    <td>" + examDate + "</td>\r\n" + "    <td>" + startTime + "</td>\r\n" + "    <td>"
				+ endTime + "</td>\r\n" + "  <tr>\r\n" + "</table><p>Thank You!</p><body><html>",
				"text/html");
		msg.setSentDate(new Date());

		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent("<html><head>\r\n" + "<style>\r\n" + "table, th, td {\r\n" + "  border: 1px solid black;\r\n"
				+ "}\r\n" + "</style>\r\n" + "</head><body><p>Hi " + firstName
				+ ",</p><p> Reminder for your exam !!</p>\r\n"
				+ "                <table style=\"border:1px solid balck;\" >\r\n" + "  <tr style=\"width:100%\">\r\n"
				+ "    <th>Exam Name</th>\r\n" + "    <th>Exam Date</th> \r\n" + "    <th>Start Time</th>\r\n"
				+ "    <th>End Time</th>\r\n" + "  </tr>\r\n" + "  	<td>" + examName + "</td>\r\n"
				+ "    <td>" + examDate + "</td>\r\n" + "    <td>" + startTime + "</td>\r\n" + "    <td>"
				+ endTime + "</td>\r\n" + "  <tr>\r\n" + "</table><p>Thank You!</p><body><html>",
				"text/html");
		Transport.send(msg);
	}

	@Override
	public void sendReminder(Exam exam, User user) {
		String userEmail = user.getEmail();

		String firstName = user.getFirstName();

		String examName = exam.getExamName();

		LocalDate examDate = exam.getExamDate();

		LocalTime startTime = exam.getStartTime();

		LocalTime endTime = exam.getEndTime();

		try {
			sendmail(userEmail, firstName, examName, examDate, startTime, endTime);
		} catch (MessagingException | IOException e) {

		}
	}

	@Override
	public Exam manageSeatsForExam(Long examId) {
		
		Exam exam = findById(examId);
		
		exam.setAvailableSeats(exam.getAvailableSeats()-1);
		
		return this.updateInfo(exam);
	}

}
