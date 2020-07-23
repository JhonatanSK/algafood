package com.jhonatan.algafood.domain.repository;

import java.util.List;

import com.jhonatan.algafood.domain.model.Restaurante;

public interface RestauranteRepository {

	List<Restaurante> listar();
	Restaurante buscar(Long id);
	Restaurante adicionar(Restaurante restaurante);
	void remover(Restaurante restaurante);
}
