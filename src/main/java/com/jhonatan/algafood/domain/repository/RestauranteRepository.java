package com.jhonatan.algafood.domain.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.jhonatan.algafood.domain.model.Restaurante;

public interface RestauranteRepository  extends CustomJpaRepository <Restaurante, Long>, 	
		RestauranteRepositoryQueries, JpaSpecificationExecutor<Restaurante> {

}
