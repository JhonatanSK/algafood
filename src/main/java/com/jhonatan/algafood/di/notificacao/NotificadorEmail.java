package com.jhonatan.algafood.di.notificacao;

import org.springframework.stereotype.Component;

import com.jhonatan.algafood.di.model.Cliente;

@TipoDoNotificador(NivelUrgencia.URGENTE)
@Component
public class NotificadorEmail implements Notificador {
	
	@Override
	public void notificar(Cliente cliente, String mensagem) {
		System.out.printf("Notificando %s através do e-mail %s: %s\n", 
				cliente.getNome(), cliente.getEmail(), mensagem);
	}

}