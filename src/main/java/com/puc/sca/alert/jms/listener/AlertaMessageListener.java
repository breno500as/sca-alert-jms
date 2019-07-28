package com.puc.sca.alert.jms.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.puc.sca.integration.util.Alerta;
import com.puc.sca.integration.util.Constants;



@Component
public class AlertaMessageListener {
	
	@JmsListener(destination = Constants.TOPICO_MODULO_SEGURACA)
	public void receiveAlert(Alerta alerta) {
       System.out.println(alerta.getNivel());
	}

}
