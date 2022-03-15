package com.yurijivago.algalog.domain.service;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yurijivago.algalog.domain.model.Cliente;
import com.yurijivago.algalog.domain.model.Entrega;
import com.yurijivago.algalog.domain.model.StatusEntrega;
import com.yurijivago.algalog.domain.repository.EntregaRopository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {

	private CatalogoClienteService catalogoClienteService;
	private EntregaRopository entregaRopository;
	
	@Transactional
	public Entrega solicitar(Entrega entrega) {
		Cliente cliente = catalogoClienteService.buscar(entrega.getCliente().getId());
		
		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(OffsetDateTime.now());
		
		return entregaRopository.save(entrega);
	}
}
