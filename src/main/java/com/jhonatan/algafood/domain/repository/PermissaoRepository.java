package com.jhonatan.algafood.domain.repository;

import java.util.List;

import com.jhonatan.algafood.domain.model.Permissao;

public interface PermissaoRepository {
	
	List<Permissao> listar();
	Permissao buscar(Long id);
	Permissao adicionar(Permissao permissao);
	void remover(Permissao permissao);
}