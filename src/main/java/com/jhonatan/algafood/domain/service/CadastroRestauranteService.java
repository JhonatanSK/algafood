package com.jhonatan.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhonatan.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.jhonatan.algafood.domain.model.Cozinha;
import com.jhonatan.algafood.domain.model.Restaurante;
import com.jhonatan.algafood.domain.repository.CozinhaRepository;
import com.jhonatan.algafood.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {

	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	public Restaurante salvar(Restaurante restaurante) {
		Long cozinhaId = restaurante.getCozinha().getId();
		
		Cozinha cozinha = cozinhaRepository.findById(cozinhaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(
						String.format("Não existe cadastro de cozinha com o codigo %d", cozinhaId)));
		
		restaurante.setCozinha(cozinha);
		
		return restauranteRepository.save(restaurante);
	}
	
	public Restaurante atualizar(Restaurante restaurante) {
		Long cozinhaId = restaurante.getCozinha().getId();
		
		cozinhaRepository.findById(cozinhaId)
				.orElseThrow(() ->  new EntidadeNaoEncontradaException(
						String.format("Não existe cadastro de cozinha com o codigo %d", cozinhaId)));
		
		restauranteRepository.findById(restaurante.getId())
				.orElseThrow(() -> new EntidadeNaoEncontradaException(
						String.format("Não existe cadastro de restaurante com o codigo %d", restaurante.getId())));
		
		return restauranteRepository.save(restaurante);
	}
}
