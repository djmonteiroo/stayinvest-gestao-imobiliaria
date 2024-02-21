package com.stayinveste.lib.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "estado_imovel")
public class EstadoUFEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEstadoImovel;

	@NotEmpty(message = "Estado de localização não pode ser vazio")
	private String nmEstadoImovel;
	
	@NotEmpty(message = "UF do estado não pode ser nulo")
	private String ufEstado;

	private Integer inAtivo;

	@CreatedDate
	private LocalDateTime dtInclusao;

	@CreatedDate
	private LocalDateTime dtAlteracao;
}
