package com.jhonatan.algafood.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.jhonatan.algafood.di.notificacao.NivelUrgencia;
import com.jhonatan.algafood.di.notificacao.Notificador;
import com.jhonatan.algafood.di.notificacao.TipoDoNotificador;
import com.jhonatan.algafood.di.service.ClienteAtivadoEvent;

@Component
public class NotificacaoService {

	@TipoDoNotificador(NivelUrgencia.URGENTE)
	@Autowired
	private Notificador notificador;
	
	@EventListener
	public void clienteAtivadoListener(ClienteAtivadoEvent event) {
		notificador.notificar(event.getCliente(), "Seu cadastro está ativo no sistema");
	}
}
