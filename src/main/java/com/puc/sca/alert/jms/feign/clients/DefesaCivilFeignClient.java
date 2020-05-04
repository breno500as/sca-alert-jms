package com.puc.sca.alert.jms.feign.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.puc.util.pojo.Alerta;


@FeignClient(name = "defesa-civil-Feign-client" , url = "${url.integracao.defesa.civil}")
public interface DefesaCivilFeignClient {

	@PostMapping("/defesa-civil-mock/alertas-barragem")
	public void postAlerta(Alerta alerta);

}
