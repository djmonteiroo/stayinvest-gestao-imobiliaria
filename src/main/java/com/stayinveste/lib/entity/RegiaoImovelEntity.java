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
@Table(name = "regiao_imovel")
public class RegiaoImovelEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRegiaoImovel;

	@NotEmpty(message = "Região do Imóvel não pode ser nulo")
	private String nmRegiaoImovel;

	private Integer inAtivo;

	@CreatedDate
	private LocalDateTime dtInclusao;

	@CreatedDate
	private LocalDateTime dtAlteracao;
}
