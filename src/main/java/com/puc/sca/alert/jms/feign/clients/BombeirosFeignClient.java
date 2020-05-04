package com.puc.sca.alert.jms.feign.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.puc.util.pojo.Alerta;

@FeignClient(name = "bombeiros-feign-client" , url = "${url.integracao.bombeiros}")
public interface BombeirosFeignClient {
	
	@PostMapping("/bombeiros/alertas-barragem")
	public void postAlerta(Alerta alerta);

}
