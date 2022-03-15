package com.yurijivago.algalog.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yurijivago.algalog.domain.model.Entrega;
import com.yurijivago.algalog.domain.repository.EntregaRopository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FinalizacaoEntregaService {
	
	private EntregaRopository entregaRopository;
	private BuscaEntregaService buscaEntregaService;
	
	@Transactional
	public void finalizar(Long entregaId) {
		Entrega entrega = buscaEntregaService.buscar(entregaId);
		entrega.finalizar();
		entregaRopository.save(entrega);
		
	}

}
