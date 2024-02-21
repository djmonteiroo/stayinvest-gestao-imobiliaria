package com.stayinveste.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.stayinveste.lib.dto.RegiaoImovelDto;
import com.stayinveste.lib.entity.RegiaoImovelEntity;

@Component
public class RegiaoImovelMapper {

	@SuppressWarnings("static-access")
	public RegiaoImovelEntity mapearRegiaoImovel(final RegiaoImovelDto regiaoImovelDto) {
		return new RegiaoImovelEntity()
				.builder()
					.nmRegiaoImovel(regiaoImovelDto.getNmRegiaoImovel())
					.inAtivo(1)
					.dtInclusao(LocalDateTime.now())
				.build();

	}

	public List<RegiaoImovelDto> comporListaSaida(List<RegiaoImovelEntity> lsRegiaoImovel) {
		List<RegiaoImovelDto> lsRegiaoImovelDto = new ArrayList<RegiaoImovelDto>();
		lsRegiaoImovel.forEach(regiao -> {
			RegiaoImovelDto dto = new RegiaoImovelDto();
			dto.setIdRegiaoImovel(regiao.getIdRegiaoImovel());
			dto.setNmRegiaoImovel(regiao.getNmRegiaoImovel());
			if (regiao.getInAtivo().equals(1)) {
				dto.setInAtivo(Boolean.TRUE);
			} else {
				dto.setInAtivo(Boolean.FALSE);
			}
			dto.setDtInclusao(regiao.getDtInclusao());
			dto.setDtAlteracao(regiao.getDtAlteracao());
			lsRegiaoImovelDto.add(dto);
		});

		return lsRegiaoImovelDto;
	}

}
