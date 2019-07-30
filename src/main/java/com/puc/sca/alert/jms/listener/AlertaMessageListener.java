package com.puc.sca.alert.jms.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.puc.sca.alert.jms.service.EmailService;
import com.puc.sca.alert.jms.service.SmsService;
import com.puc.sca.integration.util.Alerta;
import com.puc.sca.integration.util.Constants;
import com.puc.sca.integration.util.NivelAlerta;



@Component
public class AlertaMessageListener {
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private SmsService smsService;
	
	@JmsListener(destination = Constants.TOPICO_MODULO_SEGURACA)
	public void receiveAlert(Alerta alerta) {
		
		String assunto = "";
		String mensagem = "";
         
		 if (NivelAlerta.NIVEL_4_ROMPIMENTO_IMINENTE.equals(alerta.getNivel())) {
			  assunto = "Risco Iminente de rompimento de barragem";
			  mensagem = "Saia imediatamente do local e siga os procedimentos de segurança...";
		 } else if (NivelAlerta.NIVEL_3_ALTO.equals(alerta.getNivel())) {
			 assunto = "Risco alto de rompimento de barragem";
			 mensagem = "É recomendado ir para um outro local...";
		 }
		 

		 this.emailService.send(assunto, mensagem);
		 this.smsService.send(mensagem);
	}

}
