package com.jhonatan.algafood.di.notificacao;

import com.jhonatan.algafood.di.model.Cliente;

public interface Notificador {

	void notificar(Cliente cliente, String mensagem);

}