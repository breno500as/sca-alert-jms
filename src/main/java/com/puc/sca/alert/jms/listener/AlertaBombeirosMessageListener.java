package com.puc.sca.alert.jms.listener;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.puc.sca.integration.util.Alerta;
import com.puc.sca.integration.util.Constants;

@Component
public class AlertaBombeirosMessageListener extends AlertMessageListener {

	@Value("${url.integracao.bombeiros}")
	private String bombeiroslUrl;

	@Override
	@JmsListener(destination = Constants.TOPICO_MODULO_SEGURACA_INTEGRACAO_SISTEMA_CORPO_DE_BOMBEIROS)
	public void receiveAlert(Alerta alerta) {
		try {
			// Implementação do envio do json para uma api de integração dos bombeiros,
			// aqui podem ser implementadas regras de negócio específicas, segurança, etc.
			//super.postAlert(this.bombeiroslUrl, alerta);
		} catch (Exception e) {
			// Logar erro e levantar runtime exception
			throw new RuntimeException(e);
		}

	}

}
