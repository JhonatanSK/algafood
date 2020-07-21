package com.jhonatan.algafood.di.notificacao;

import org.springframework.stereotype.Component;

import com.jhonatan.algafood.di.model.Cliente;

@TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
@Component
public class NotificadorSMS implements Notificador{
	@Override
	public void notificar(Cliente cliente, String mensagem) {
		System.out.printf("Notificando %s através do telefone %s: %s\n", 
				cliente.getNome(), cliente.getTelefone(), mensagem);
	}
}
