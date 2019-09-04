package com.puc.sca.alert.jms.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.puc.sca.alert.jms.service.EmailService;
import com.puc.sca.alert.jms.service.SmsService;
import com.puc.sca.alert.jms.service.WhatsAppService;
import com.puc.sca.integration.util.Alerta;
import com.puc.sca.integration.util.Constants;


/**
 * Tópico JMS que dispara sirenes e alarmes via emails, sms e whatsapp e comunicando também os interessados.
 * @author breno
 *
 */

@Component
public class AlertaSegurancaComunicacaoMessageListener extends AlertMessageListener {

	@Autowired
	private EmailService emailService;

	@Autowired
	private SmsService smsService;

	@Autowired
	private WhatsAppService whatsAppService;

	@Override
	@JmsListener(destination = Constants.TOPICO_MODULO_SEGURACA_COMUNICACAO_EVACUACAO)
	public void receiveAlert(Alerta alerta) {

		String assunto = "Risco Iminente de rompimento de barragem";
		String mensagem = "Saia imediatamente do local e siga os procedimentos de segurança...";

	//	this.emailService.send(assunto, mensagem);
		this.smsService.send(mensagem);
		this.whatsAppService.send(mensagem);
	}

}
