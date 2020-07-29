package com.jhonatan.algafood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhonatan.algafood.domain.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{
	
}
