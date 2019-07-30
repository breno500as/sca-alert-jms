package com.puc.sca.alert.jms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Value("${emails}")
	private String emails;

	@Autowired
	public JavaMailSender emailSender;

	public void send(String subject, String text) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(this.emails);
		message.setSubject(subject);
		message.setText(text);
		emailSender.send(message);

	}

}
