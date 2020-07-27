package com.jhonatan.algafood.domain.repository;

import java.util.List;

import com.jhonatan.algafood.domain.model.Estado;

public interface EstadoRepository{
	List<Estado> listar();
	Estado buscar(Long id);
	Estado adicionar(Estado estado);
	void remover(Long id);
}
