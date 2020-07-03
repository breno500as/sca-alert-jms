package com.puc.sca.alert.jms.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.puc.sca.alert.jms.feign.clients.DefesaCivilFeignClient;
import com.puc.sca.util.pojo.Alerta;
import com.puc.sca.util.pojo.Constants;

/**
 * Tópico JMS que envia alertas para o sistema terceiro da defesa civil.
 * @author breno
 *
 */

@Component
public class AlertaDefesaCivilMessageListener {

 
	@Autowired
	private DefesaCivilFeignClient defesaCivilFeignClient;

	 
	@JmsListener(destination = Constants.TOPICO_MODULO_SEGURACA_INTEGRACAO_SISTEMA_DEFESA_CIVIL)
	public void receiveAlert(Alerta alerta) {

		try {
			// Implementação do envio do json para uma api de integração da defesa civil,
			// aqui podem ser implementadas regras de negócio específicas, segurança, etc.
		    
			this.defesaCivilFeignClient.postAlerta(alerta);
			
		} catch (Exception e) {
			// Logar erro e levantar runtime exception
			throw new RuntimeException(e);
		}

	}

}
