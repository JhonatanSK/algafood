package com.jhonatan.algafood.di.notificacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jhonatan.algafood.di.model.Cliente;

@TipoDoNotificador(NivelUrgencia.URGENTE)
@Component
public class NotificadorEmail implements Notificador {
	
	@Autowired
	private NotificadorProperties notificadorProperties;
	
	@Override
	public void notificar(Cliente cliente, String mensagem) {
		System.out.println("HOST: " + notificadorProperties.getHostServidor() 
		+"\nPORTA: " + notificadorProperties.getPortaServidor());
		
		System.out.printf("Notificando %s através do e-mail %s: %s\n", 
				cliente.getNome(), cliente.getEmail(), mensagem);
	}

}