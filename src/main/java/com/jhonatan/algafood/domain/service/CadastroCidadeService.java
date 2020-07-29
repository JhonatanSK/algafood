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
		Estado estado = estadoRepository.findById(idEstado)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(
						String.format("Não existe cadastro de estado com o codigo %d", idEstado)));
	
		cidade.setEstado(estado);
		return cidadeRepository.save(cidade);
	}
	
	public Cidade atualizar(Cidade cidade) {
		Long estadoId = cidade.getEstado().getId();
		
		estadoRepository.findById(estadoId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(
						String.format("Não existe cadastro de estado com o codigo %d", estadoId)));
		
		cidadeRepository.findById(cidade.getId())
		.orElseThrow(() -> new EntidadeNaoEncontradaException(
				String.format("Não existe cadastro de cidade com o codigo %d", cidade.getId())));
		
		
		return cidadeRepository.save(cidade);
	}
	
	public void excluir(Long id) {
		cidadeRepository.findById(id)
		.orElseThrow(() -> new EntidadeNaoEncontradaException(
				String.format("Não existe cadastro de cidade com o codigo %d", id)));
		
		cidadeRepository.deleteById(id);
		
	}
}
