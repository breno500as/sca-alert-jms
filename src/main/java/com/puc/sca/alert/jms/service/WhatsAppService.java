package com.puc.sca.alert.jms.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WhatsAppService {

	@Value("${telefones}")
	private String telefones;

	// https://www.twilio.com/whatsapp
	// https://www.twilio.com/docs/sms/whatsapp/quickstart/java
	public void send(String assunto) {
	}
}
