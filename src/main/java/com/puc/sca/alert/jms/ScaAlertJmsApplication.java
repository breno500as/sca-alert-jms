package com.puc.sca.alert.jms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;

/**
 * 1 - Baixar o activemq: https://activemq.apache.org/components/classic/download/
 * 2 - Descompactar ir na basta bin executar o comando: sudo ./activemq start 
 * 3 - URL do message broker para configurações: http://localhost:8161/admin 
 * 4 - Logar: usuário: admin
 *            senha: admin
 * 
 * @author Breno
 *
 */

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication(scanBasePackages = { "com.puc.sca.util.*", "com.puc.sca.alert.jms.*" })
@PropertySource(value = "file:${caminho.sca-util.application.properties}", ignoreResourceNotFound = true)
public class ScaAlertJmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScaAlertJmsApplication.class, args);
	}

}
