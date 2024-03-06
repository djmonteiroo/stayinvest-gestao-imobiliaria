package com.stayinveste.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stayinveste.lib.dto.TipoImovelDto;
import com.stayinveste.lib.entity.TipoImovelEntity;
import com.stayinveste.mapper.TipoImovelMapper;
import com.stayinveste.repository.TipoImovelRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TipoImovelService {

	@Autowired
	private TipoImovelMapper mapper;

	@Autowired
	private TipoImovelRepository repository;

	public String criarTipoImovel(final TipoImovelDto tipoImovelDto) {
		log.info("Realizando cadastro de tipo");
		try {
			TipoImovelEntity mapearTipoImovel = mapper.mapearTipoImovel(tipoImovelDto);
			repository.registrarTipoImovel(mapearTipoImovel);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Novo tipo cadastrado com Sucesso!";
	}

	public List<TipoImovelDto> consultarTiposImoveis() {
		log.info("Realizando consulta de tipo de imoveis cadastrados.");
		return mapper.comporListaSaida(repository.buscarTodos());

	}

	public void desabilitarTipoImovel(final Long idTipoImovel) {
		try {
			repository.desabilitarTipoImovel(idTipoImovel);
			log.info("Operação realizada com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void ativarTipoImovel(final Long idTipoImovel) {
		try {
			repository.ativarTipoImovel(idTipoImovel);
			log.info("Operação realizada com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deletarTipoImovel(final Long idTipoImovel) {
		try {
			repository.deletarTipoImovel(idTipoImovel);
			log.info("Operação realizada com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}