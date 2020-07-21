package com.jhonatan.algafood;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jhonatan.algafood.di.notificacao.NotificadorEmail;

@Configuration
public class NotificacaoConfig {

	@Bean
	public NotificadorEmail notificadorEmail() {
		NotificadorEmail notificador = new NotificadorEmail("smtp.jhon.costa");
		notificador.setCaixaAlta(true);
		
		return notificador;
	}
}
