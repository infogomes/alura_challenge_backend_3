package br.com.infogomes.analysisfinancial.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import br.com.infogomes.analysisfinancial.services.EmailService;

public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender emailSender;

	public void send(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("noreply@infogomes.com");
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		emailSender.send(message);
	}
}
