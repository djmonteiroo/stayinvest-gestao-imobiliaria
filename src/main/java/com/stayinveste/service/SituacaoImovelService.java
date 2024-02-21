package com.stayinveste.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stayinveste.lib.dto.SituacaoImovelDto;
import com.stayinveste.lib.entity.SituacaoImovelEntity;
import com.stayinveste.mapper.SituacaoImovelMapper;
import com.stayinveste.repository.SituacaoImovelRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SituacaoImovelService {

	@Autowired
	private SituacaoImovelMapper mapper;

	@Autowired
	private SituacaoImovelRepository repository;

	public String criarSituacaoImovel(final SituacaoImovelDto situacaoImovelDto) {
		log.info("Realizando cadastro de tipo");
		try {
			SituacaoImovelEntity mapearSituacaoImovel = mapper.mapearSituacaoImovel(situacaoImovelDto);
			repository.registrarSituacaoImovel(mapearSituacaoImovel);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Nova situação cadastrado com Sucesso!";
	}

	public List<SituacaoImovelDto> consultarSituacaoImoveis() {
		return mapper.comporListaSaida(repository.buscarTodos());

	}

	public void desabilitarSituacaoImovel(final Long idTipoImovel) {
		try {
			repository.desabilitarSituacaoImovel(idTipoImovel);
			log.info("Operação realizada com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void ativarTipoImovel(final Long idTipoImovel) {
		try {
			repository.ativarSituacaoImovel(idTipoImovel);
			log.info("Operação realizada com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deletarSituacaoImovel(final Long idTipoImovel) {
		try {
			repository.deletarSituacaoImovel(idTipoImovel);
			log.info("Operação realizada com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}