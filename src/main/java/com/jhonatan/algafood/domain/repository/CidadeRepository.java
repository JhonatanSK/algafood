package com.jhonatan.algafood.domain.repository;

import java.util.List;

import com.jhonatan.algafood.domain.model.Cidade;

public interface CidadeRepository{
	
	List<Cidade> listar();
	Cidade buscar(Long id);
	Cidade adicionar(Cidade cidade);
	void remover(Cidade cidade);
}
