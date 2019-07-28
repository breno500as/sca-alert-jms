package com.puc.sca.alert.jms.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.puc.sca.integration.pojo.Alerta;



@Component
public class AlertaMessageListener {

	@JmsListener(destination = "topic.alerta-box")
	public void receiveAlert(Alerta alerta) {
       System.out.println(alerta.getNivel());
	}

}
