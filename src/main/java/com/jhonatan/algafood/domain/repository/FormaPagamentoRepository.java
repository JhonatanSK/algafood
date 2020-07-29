package com.jhonatan.algafood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhonatan.algafood.domain.model.FormaPagamento;

public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long>{
	
}
