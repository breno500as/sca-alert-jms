package com.puc.sca.alert.jms.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.puc.sca.alert.jms.service.SmsService;
import com.puc.sca.alert.jms.service.WhatsAppService;
import com.puc.sca.util.mail.EmailService;
import com.puc.sca.util.pojo.Alerta;
import com.puc.sca.util.pojo.Constants;

/**
 * Tópico JMS que dispara sirenes e alarmes via emails, sms e whatsapp e
 * comunicando também os interessados.
 * 
 * @author breno
 *
 */

@Component
public class AlertaSegurancaComunicacaoMessageListener   {

	@Autowired
	private EmailService emailService;

	@Autowired
	private SmsService smsService;

	@Autowired
	private WhatsAppService whatsAppService;
	
	@Value("${emails}")
	private String emails;

	@JmsListener(destination = Constants.TOPICO_MODULO_SEGURACA_COMUNICACAO_EVACUACAO)
	public void receiveAlert(Alerta alerta) {

		try {

			String assunto = "Risco Iminente de rompimento de barragem";
			String mensagem = "Saia imediatamente do local e siga os procedimentos de segurança...";

			this.emailService.send(assunto, mensagem, this.emails);
		//	this.smsService.send(mensagem);
		//	this.whatsAppService.send(mensagem);
		} catch (Exception e) {
			// Logar erro e levantar runtime exception
			throw new RuntimeException(e);
		}

	}

}
