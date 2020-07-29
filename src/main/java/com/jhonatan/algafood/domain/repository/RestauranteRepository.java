package com.jhonatan.algafood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhonatan.algafood.domain.model.Restaurante;

public interface RestauranteRepository 
		extends JpaRepository <Restaurante, Long>, 	RestauranteRepositoryQueries {

}
