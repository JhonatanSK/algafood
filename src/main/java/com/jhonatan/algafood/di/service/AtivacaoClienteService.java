package com.jhonatan.algafood.di.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jhonatan.algafood.di.model.Cliente;
import com.jhonatan.algafood.di.notificacao.NivelUrgencia;
import com.jhonatan.algafood.di.notificacao.Notificador;
import com.jhonatan.algafood.di.notificacao.TipoDoNotificador;

@Component
public class AtivacaoClienteService {
	
	@TipoDoNotificador(NivelUrgencia.URGENTE)
	@Autowired
	private Notificador notificador;
	
	public void ativar(Cliente cliente) {
		cliente.ativar();
		
		notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
	}
}
