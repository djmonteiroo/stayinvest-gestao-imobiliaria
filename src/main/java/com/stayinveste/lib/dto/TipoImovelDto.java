package com.stayinveste.lib.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TipoImovelDto implements Serializable {

	private static final long serialVersionUID = 8894984930678276136L;

	private Long idTipoImovel;
	private String nmTipoImovel;
	private String txDescricao;
	private String inAtivo;
	private String dtInclusao;
	private String dtAlteracao;
}