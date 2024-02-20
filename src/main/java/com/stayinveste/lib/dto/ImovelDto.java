package com.stayinveste.lib.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ImovelDto implements Serializable {

	private static final long serialVersionUID = 6525999234528010150L;

	private Long codigoImovel;
	private Integer idTipoImovel;
	private LocalDateTime dtInclusao;
	private Integer idSituacaoImovel;

	public ImovelDto() {
		super();
	}

	public ImovelDto(Long codigoImovel, Integer idTipoImovel, LocalDateTime dtInclusao, Integer idSituacaoImovel) {
		super();
		this.codigoImovel = codigoImovel;
		this.idTipoImovel = idTipoImovel;
		this.dtInclusao = dtInclusao;
		this.idSituacaoImovel = idSituacaoImovel;
	}

	public Long getCodigoImovel() {
		return codigoImovel;
	}

	public void setCodigoImovel(Long codigoImovel) {
		this.codigoImovel = codigoImovel;
	}

	public Integer getIdTipoImovel() {
		return idTipoImovel;
	}

	public void setIdTipoImovel(Integer idTipoImovel) {
		this.idTipoImovel = idTipoImovel;
	}

	public LocalDateTime getDtInclusao() {
		return dtInclusao;
	}

	public void setDtInclusao(LocalDateTime dtInclusao) {
		this.dtInclusao = dtInclusao;
	}

	public Integer getIdSituacaoImovel() {
		return idSituacaoImovel;
	}

	public void setIdSituacaoImovel(Integer idSituacaoImovel) {
		this.idSituacaoImovel = idSituacaoImovel;
	}

	@Override
	public String toString() {
		return "ImovelDto [codigoImovel=" + codigoImovel + ", idTipoImovel=" + idTipoImovel + ", dtInclusao="
				+ dtInclusao + ", idSituacaoImovel=" + idSituacaoImovel + "]";
	}

}