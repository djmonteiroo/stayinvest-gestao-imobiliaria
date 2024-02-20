package com.stayinveste.lib.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

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
	private Boolean inAtivo;
	
	@DateTimeFormat(pattern = "dd/MM/YYYY hh:mm z")
	private LocalDateTime dtInclusao;
	
	@DateTimeFormat(pattern = "dd/MM/YYYY hh:mm z")
	private LocalDateTime dtAlteracao;
}