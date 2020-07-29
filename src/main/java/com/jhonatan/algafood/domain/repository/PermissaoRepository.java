package com.jhonatan.algafood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhonatan.algafood.domain.model.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Long>{
	
}
