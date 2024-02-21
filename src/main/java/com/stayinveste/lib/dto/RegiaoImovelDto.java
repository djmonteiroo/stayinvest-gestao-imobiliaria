package com.stayinveste.lib.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegiaoImovelDto {

	private Long idRegiaoImovel;
	private String nmRegiaoImovel;
	private Boolean inAtivo;
	private LocalDateTime dtInclusao;
	private LocalDateTime dtAlteracao;
}
