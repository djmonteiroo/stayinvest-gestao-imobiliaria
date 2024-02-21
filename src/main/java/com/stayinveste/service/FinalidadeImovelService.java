package com.stayinveste.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stayinveste.lib.dto.FinalidadeImovelDto;
import com.stayinveste.lib.entity.FinalidadeImovelEntity;
import com.stayinveste.mapper.FinalidadeImovelMapper;
import com.stayinveste.repository.FinalidadeImovelRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FinalidadeImovelService {

	@Autowired
	private FinalidadeImovelMapper mapper;

	@Autowired
	private FinalidadeImovelRepository repository;

	public String criarFinalidadeImovel(final FinalidadeImovelDto finalidadeImovelDto) {
		log.info("Realizando cadastro de tipo");
		try {
			FinalidadeImovelEntity mapearSituacaoImovel = mapper.mapearFinalidadeImovel(finalidadeImovelDto);
			repository.registrarFinalidadeImovel(mapearSituacaoImovel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Nova situação cadastrado com Sucesso!";
	}

	public List<FinalidadeImovelDto> consultarFinalidadeImoveis() {
		return mapper.comporListaSaida(repository.buscarTodos());
	}

	public void desabilitarFinalidadeImovel(final Long idRegiaoImovel) {
		try {
			repository.desabilitarFinalidadeImovel(idRegiaoImovel);
			log.info("Operação realizada com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void ativarFinalidadeImovel(final Long idRegiaoImovel) {
		try {
			repository.ativarFinalidadeImovel(idRegiaoImovel);
			log.info("Operação realizada com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deletarFinalidadeImovel(final Long idTipoImovel) {
		try {
			repository.deletarFinalidadeImovel(idTipoImovel);
			log.info("Operação realizada com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}