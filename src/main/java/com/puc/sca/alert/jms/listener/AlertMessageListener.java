package com.puc.sca.alert.jms.listener;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.puc.sca.integration.util.Alerta;


/**
 * Classe base para envio dos alertas no formato json para os sistemas terceiros interessados.
 * @author breno
 *
 */

public abstract class AlertMessageListener {

	public abstract void receiveAlert(Alerta alerta);

	/**
	 * Método para parsing de objeto para json e chamada http nos sistemas terceiros.
	 * @param url - url do sistema terceiro.
	 * @param alerta - { @link Alerta }
	 * @throws ClientProtocolException - exceção
	 * @throws IOException - exceção
	 */
	
	public void postAlert(String url, Alerta alerta) throws ClientProtocolException, IOException {
		
		final ObjectMapper objectMapper = new ObjectMapper();

		final HttpClient httpClient = HttpClients.createDefault();
		String json = objectMapper.writeValueAsString(alerta);

		final HttpPost httpPost = new HttpPost(url);
		StringEntity entity = new StringEntity(json);
		httpPost.setEntity(entity);
		httpPost.setHeader("Content-type", "application/json");
		httpPost.setEntity(entity);
		httpClient.execute(httpPost);
	}
}
