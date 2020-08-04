package com.jhonatan.algafood.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import com.jhonatan.algafood.domain.model.Restaurante;

public interface RestauranteRepositoryQueries {
	List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFretefinal);

	List<Restaurante> findComFreteGratis(String nome);
}
