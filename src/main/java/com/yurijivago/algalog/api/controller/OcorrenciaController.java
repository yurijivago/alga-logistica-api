package com.yurijivago.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.yurijivago.algalog.api.assembler.OcorrenciaAssembler;
import com.yurijivago.algalog.api.model.OcorrenciaModel;
import com.yurijivago.algalog.api.model.input.OcorrenciaInput;
import com.yurijivago.algalog.domain.model.Entrega;
import com.yurijivago.algalog.domain.model.Ocorrencia;
import com.yurijivago.algalog.domain.service.BuscaEntregaService;
import com.yurijivago.algalog.domain.service.RegistroOcorrenciaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {
	
	private RegistroOcorrenciaService registroOcorrenciaService;
	private OcorrenciaAssembler ocorrenciaAssembler;
	private BuscaEntregaService buscaEntregaService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OcorrenciaModel registrar(@PathVariable Long entregaId,
			@Valid @RequestBody OcorrenciaInput ocorrenciaInput) {
		Ocorrencia ocorrenciaRegistrada = registroOcorrenciaService.registrar(entregaId, ocorrenciaInput.getDescricao());
		
		return ocorrenciaAssembler.toModel(ocorrenciaRegistrada);
	}
	
	@GetMapping
	public List<OcorrenciaModel> listar(@PathVariable Long entregaId){
		Entrega entrega = buscaEntregaService.buscar(entregaId);
		
		return ocorrenciaAssembler.toCollectionModel(entrega.getOcorrencias());
	}
}
