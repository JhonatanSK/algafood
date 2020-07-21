package com.jhonatan.algafood.di.service;

import org.springframework.stereotype.Component;

import com.jhonatan.algafood.di.model.Cliente;
import com.jhonatan.algafood.di.notificacao.Notificador;

@Component
public class AtivacaoClienteService {
	
	private Notificador notificador;
	
	public AtivacaoClienteService(Notificador notificador) {
		this.notificador = notificador;
	}

	public void ativar(Cliente cliente) {
		cliente.ativar();
		notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
	}
}
