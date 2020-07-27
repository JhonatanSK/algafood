package com.jhonatan.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhonatan.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.jhonatan.algafood.domain.model.Cidade;
import com.jhonatan.algafood.domain.model.Estado;
import com.jhonatan.algafood.domain.repository.CidadeRepository;
import com.jhonatan.algafood.domain.repository.EstadoRepository;

@Service
public class CadastroCidadeService {

	@Autowired
	CidadeRepository cidadeRepository;
	
	@Autowired
	EstadoRepository estadoRepository;
	
	public Cidade salvar(Cidade cidade) {
		Long idEstado = cidade.getEstado().getId();
		Estado estado = estadoRepository.buscar(idEstado);
		
		if(estado == null) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe cadastro de estado com o codigo %d", idEstado));			
		}
		cidade.setEstado(estado);
		return cidadeRepository.adicionar(cidade);
	}
	
	public Cidade atualizar(Cidade cidade) {
		Long estadoId = cidade.getEstado().getId();
		Estado estado = estadoRepository.buscar(estadoId);
		
		Cidade cidadeVerificar = cidadeRepository.buscar(cidade.getId());
		
		if (cidadeVerificar == null) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe cadastro de cidade com o codigo %d", cidade.getId()));
		}
		if(estado == null) {
			throw new EntidadeNaoEncontradaException(
				String.format("Não existe cadastro de estado com o codigo %d", estadoId));
		}
		
		return cidadeRepository.adicionar(cidade);
	}
	
	public void excluir(Long id) {
		Cidade cidade = cidadeRepository.buscar(id);
		
		if (cidade == null) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe cadastro de cidade com o codigo %d", id));
		}
		cidadeRepository.remover(id);
		
	}
}
