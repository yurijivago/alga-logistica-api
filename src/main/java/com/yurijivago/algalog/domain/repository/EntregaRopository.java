package com.yurijivago.algalog.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yurijivago.algalog.domain.model.Entrega;

@Repository
public interface EntregaRopository extends JpaRepository<Entrega, Long>{

}
