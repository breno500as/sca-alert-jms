package com.puc.sca.alert.jms.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SmsService {

	@Value("${telefones}")
	private String telefones;

	// Cloud solution - com poucas linhas de código
	// Autenticação e envio
	// https://www.twilio.com/sms 
	// https://www.twilio.com/docs/java/install
	// 0.0570 por de custo por envio
	// outra alternativa seria comprar um GSM Modem e implementar a comunicação.
	public void send(String assunto) {
	}

}
