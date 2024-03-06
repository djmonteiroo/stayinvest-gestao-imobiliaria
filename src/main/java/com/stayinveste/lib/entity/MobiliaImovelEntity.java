//package com.stayinveste.lib.entity;
//
//import java.time.LocalDateTime;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//import org.springframework.data.annotation.CreatedDate;
//
//import jakarta.persistence.Table;
//import jakarta.validation.constraints.NotEmpty;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Entity
//@Getter
//@Setter
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@Table(name = "mobilia_imovel")
//public class MobiliaImovelEntity {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long idMobiliaImovel;
//
//	@NotEmpty(message = "Tipo de Mobilia nao pode ser vazio")
//	private String nmMobiliaImovel;
//	
//	@NotEmpty(message = "Informe uma descrição")
//	private String txDescricao;
//
//	private Integer inAtivo;
//
//	@CreatedDate
//	private LocalDateTime dtInclusao;
//
//	@CreatedDate
//	private LocalDateTime dtAlteracao;
//}
