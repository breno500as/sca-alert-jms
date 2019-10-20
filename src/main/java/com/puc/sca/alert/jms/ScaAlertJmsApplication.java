package com.puc.sca.alert.jms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Baixar o activemq: https://activemq.apache.org/components/classic/download/
 * Descompactar
 * Ir na basta bin  executar o comando: sudo ./activemq start
 * URL do message broker para configurações http://localhost:8161/admin
 * usuário: admin 
 * senha: admin
 * @author Breno
 *
 */

@SpringBootApplication
@EnableDiscoveryClient
public class ScaAlertJmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScaAlertJmsApplication.class, args);
	}

}
