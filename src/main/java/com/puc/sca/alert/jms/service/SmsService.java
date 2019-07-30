package com.puc.sca.alert.jms.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SmsService {

	@Value("${telefones}")
	private String telefones;

	public void send(String assunto) {
        
	}

}
