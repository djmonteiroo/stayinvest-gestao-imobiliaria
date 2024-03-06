package com.stayinveste.mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.stayinveste.lib.dto.TipoImovelDto;
import com.stayinveste.lib.entity.TipoImovelEntity;

@Component
public class TipoImovelMapper {

	public TipoImovelEntity mapearTipoImovel(final TipoImovelDto tipoImovelDto) {
		new TipoImovelEntity();
		return TipoImovelEntity
			.builder()
			.nmTipoImovel(tipoImovelDto.getNmTipoImovel())
			.txDescricao(tipoImovelDto.getTxDescricao())
			.inAtivo(1)
			.dtInclusao(LocalDateTime.now())
			.build();
	}

	public List<TipoImovelDto> comporListaSaida(List<TipoImovelEntity> lsTipoImovelEntity) {
		List<TipoImovelDto> lsTipoImovelDto = new ArrayList<TipoImovelDto>();
		lsTipoImovelEntity.forEach(tipo -> {
			TipoImovelDto tipoImovelDto = new TipoImovelDto();
			tipoImovelDto.setIdTipoImovel(tipo.getIdTipoImovel());
			tipoImovelDto.setNmTipoImovel(tipo.getNmTipoImovel());
			tipoImovelDto.setTxDescricao(tipo.getTxDescricao());
			if(tipo.getInAtivo() == 1) {
				tipoImovelDto.setInAtivo("Sim");
			}else {
				tipoImovelDto.setInAtivo("Não");
			}
			tipoImovelDto.setDtInclusao(formatarDataHora(tipo.getDtInclusao()));
			if(Objects.nonNull(tipo.getDtAlteracao()))
				tipoImovelDto.setDtAlteracao(formatarDataHora(tipo.getDtAlteracao()));
			else {
				tipoImovelDto.setDtAlteracao("");
			}
			lsTipoImovelDto.add(tipoImovelDto);
		});
		return lsTipoImovelDto;
	}
	
	private String formatarDataHora(LocalDateTime data) {
        
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return data.format(dateTimeFormatter);
        
	}
}
