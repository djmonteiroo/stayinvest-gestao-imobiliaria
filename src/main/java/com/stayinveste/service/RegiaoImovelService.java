package com.stayinveste.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stayinveste.lib.dto.RegiaoImovelDto;
import com.stayinveste.lib.entity.RegiaoImovelEntity;
import com.stayinveste.mapper.RegiaoImovelMapper;
import com.stayinveste.repository.RegiaoImovelRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RegiaoImovelService {

	@Autowired
	private RegiaoImovelMapper mapper;

	@Autowired
	private RegiaoImovelRepository repository;

	public String criarRegiaoImovel(final RegiaoImovelDto RegiaoImovelDto) {
		log.info("Realizando cadastro de tipo");
		try {
			RegiaoImovelEntity mapearSituacaoImovel = mapper.mapearRegiaoImovel(RegiaoImovelDto);
			repository.registrarRegiaoImovel(mapearSituacaoImovel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Nova situação cadastrado com Sucesso!";
	}

	public List<RegiaoImovelDto> consultarRegiaoImoveis() {
		return mapper.comporListaSaida(repository.buscarTodos());

	}

	public void desabilitarRegiaoImovel(final Long idRegiaoImovel) {
		try {
			repository.desabilitarRegiaoImovel(idRegiaoImovel);
			log.info("Operação realizada com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void ativarRegiaoImovel(final Long idRegiaoImovel) {
		try {
			repository.ativarRegiaoImovel(idRegiaoImovel);
			log.info("Operação realizada com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deletarRegiaoImovel(final Long idTipoImovel) {
		try {
			repository.deletarRegiaoImovel(idTipoImovel);
			log.info("Operação realizada com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}