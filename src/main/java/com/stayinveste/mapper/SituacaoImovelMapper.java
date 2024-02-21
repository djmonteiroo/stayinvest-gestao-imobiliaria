package com.stayinveste.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.stayinveste.lib.dto.SituacaoImovelDto;
import com.stayinveste.lib.entity.SituacaoImovelEntity;

@Component
public class SituacaoImovelMapper {

	@SuppressWarnings("static-access")
	public SituacaoImovelEntity mapearSituacaoImovel(final SituacaoImovelDto situacaoImovelDto) {
		return new SituacaoImovelEntity().builder().nmSituacaoImovel(situacaoImovelDto.getNmSituacaoImovel())
				.txDescricao(situacaoImovelDto.getTxDescricaoSituacao()).inAtivo(1).dtInclusao(LocalDateTime.now())
				.build();

	}

	public List<SituacaoImovelDto> comporListaSaida(List<SituacaoImovelEntity> lsSituacaoImovel) {
		ArrayList<SituacaoImovelDto> lsSituacaoImovelDto = new ArrayList<SituacaoImovelDto>();
		lsSituacaoImovel.forEach(situacao -> {
			SituacaoImovelDto dto = new SituacaoImovelDto();
			dto.setIdSituacaoImovel(situacao.getIdSituacaoImovel());
			dto.setNmSituacaoImovel(situacao.getNmSituacaoImovel());
			dto.setTxDescricaoSituacao(situacao.getTxDescricao());
			if (situacao.getInAtivo().equals(1)) {
				dto.setInAtivo(Boolean.TRUE);
			} else {
				dto.setInAtivo(Boolean.FALSE);
			}
			dto.setDtInclusao(situacao.getDtInclusao());
			dto.setDtAlteracao(situacao.getDtAlteracao());
			lsSituacaoImovelDto.add(dto);
		});

		return lsSituacaoImovelDto;
	}

}
