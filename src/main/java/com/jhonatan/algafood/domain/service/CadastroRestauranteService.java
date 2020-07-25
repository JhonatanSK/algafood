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
		Cozinha cozinha = cozinhaRepository.buscar(cozinhaId);
		
		if(cozinha == null) {
			throw new EntidadeNaoEncontradaException(
				String.format("Não existe cadastro de cozinha com o codigo %d", cozinhaId));
		}
		restaurante.setCozinha(cozinha);
		
		return restauranteRepository.adicionar(restaurante);
	}
	
	public Restaurante atualizar(Restaurante restaurante) {
		Long cozinhaId = restaurante.getCozinha().getId();
		Cozinha cozinha = cozinhaRepository.buscar(cozinhaId);
		
		Restaurante restauranteVerificar = restauranteRepository.buscar(restaurante.getId());
		
		if (restauranteVerificar == null) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe cadastro de restaurante com o codigo %d", restaurante.getId()));
		}
		if(cozinha == null) {
			throw new EntidadeNaoEncontradaException(
				String.format("Não existe cadastro de cozinha com o codigo %d", cozinhaId));
		}
		
		return restauranteRepository.adicionar(restaurante);
	}
}
