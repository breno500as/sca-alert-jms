package com.puc.sca.alert.jms.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.puc.sca.alert.jms.feign.clients.BombeirosFeignClient;
import com.puc.sca.util.pojo.Alerta;
import com.puc.sca.util.pojo.Constants;


/**
 * Tópico JMS que envia alertas para o sistema terceiro dos bombeiros.
 * @author breno
 *
 */

@Component
public class AlertaBombeirosMessageListener  {

	@Autowired
	private BombeirosFeignClient bombeirosFeignClient;

	@JmsListener(destination = Constants.TOPICO_MODULO_SEGURACA_INTEGRACAO_SISTEMA_CORPO_DE_BOMBEIROS)
	public void receiveAlert(Alerta alerta) {
		try {
			// Implementação do envio do json para uma api de integração dos bombeiros,
			// aqui podem ser implementadas regras de negócio específicas, segurança, etc.
		 
			// this.bombeirosFeignClient.postAlerta(alerta);
		} catch (Exception e) {
			// Logar erro e levantar runtime exception
			throw new RuntimeException(e);
		}

	}

}
