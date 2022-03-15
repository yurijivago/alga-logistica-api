package com.yurijivago.algalog.domain.service;

import org.springframework.stereotype.Service;

import com.yurijivago.algalog.domain.exception.EntidadeNaoEncontradaException;
import com.yurijivago.algalog.domain.model.Entrega;
import com.yurijivago.algalog.domain.repository.EntregaRopository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BuscaEntregaService {
	
	private EntregaRopository entregaRopository;
	
	public Entrega buscar(Long entregaId) {
		return entregaRopository.findById(entregaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));
	}
}
