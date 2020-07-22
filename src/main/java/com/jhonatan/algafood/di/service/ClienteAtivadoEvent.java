package com.jhonatan.algafood.di.service;

import com.jhonatan.algafood.di.model.Cliente;

public class ClienteAtivadoEvent {

	private Cliente cliente;

	public ClienteAtivadoEvent(Cliente cliente) {
		super();
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
}
