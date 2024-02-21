package com.stayinveste.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.stayinveste.lib.dto.FinalidadeImovelDto;
import com.stayinveste.lib.entity.FinalidadeImovelEntity;

@Component
public class FinalidadeImovelMapper {

	@SuppressWarnings("static-access")
	public FinalidadeImovelEntity mapearFinalidadeImovel(final FinalidadeImovelDto FinalidadeImovelDto) {
		return new FinalidadeImovelEntity().builder().nmFinalidadeImovel(FinalidadeImovelDto.getNmFinalidadeImovel())
				.inAtivo(1).dtInclusao(LocalDateTime.now()).build();

	}

	public List<FinalidadeImovelDto> comporListaSaida(List<FinalidadeImovelEntity> lsFinalidadeImovel) {
		List<FinalidadeImovelDto> lsFinalidadeImovelDto = new ArrayList<FinalidadeImovelDto>();
		lsFinalidadeImovel.forEach(Finalidade -> {
			FinalidadeImovelDto dto = new FinalidadeImovelDto();
			dto.setIdFinalidadeImovel(Finalidade.getIdFinalidadeImovel());
			dto.setNmFinalidadeImovel(Finalidade.getNmFinalidadeImovel());
			if (Finalidade.getInAtivo().equals(1)) {
				dto.setInAtivo(Boolean.TRUE);
			} else {
				dto.setInAtivo(Boolean.FALSE);
			}
			dto.setDtInclusao(Finalidade.getDtInclusao());
			dto.setDtAlteracao(Finalidade.getDtAlteracao());
			lsFinalidadeImovelDto.add(dto);
		});

		return lsFinalidadeImovelDto;
	}
}