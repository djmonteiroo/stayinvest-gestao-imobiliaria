package com.stayinveste.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.stayinveste.lib.entity.FinalidadeImovelEntity;

@Repository
@PropertySource(value = "classpath:query/finalidade-imovel.properties")
public class FinalidadeImovelRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Value("${INSERT.FINALIDADE.IMOVEL}")
	private String inserirFinalidadeImovel;

	@Value("${BUSCAR.TODAS.FINALIDADES.IMOVEIS}")
	private String buscarTodasFinalidadesImovel;

	@Value("${DESABILITAR.FINALIDADE.IMOVEL}")
	private String desabilitarFinalidadeImovel;

	@Value("${ATIVAR.FINALIDADE.IMOVEL}")
	private String ativarFinalidadeImovel;

	@Value("${DELETAR.FINALIDADE.IMOVEL}")
	private String deletarFinalidadeImovel;

	public void registrarFinalidadeImovel(final FinalidadeImovelEntity FinalidadeImovel) {
		try {
			jdbcTemplate.update(inserirFinalidadeImovel, FinalidadeImovel.getNmFinalidadeImovel(),
					FinalidadeImovel.getInAtivo(), FinalidadeImovel.getDtInclusao());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public List<FinalidadeImovelEntity> buscarTodos() {
		return jdbcTemplate.query(buscarTodasFinalidadesImovel, new BeanPropertyRowMapper<>(FinalidadeImovelEntity.class));

	}

	public void desabilitarFinalidadeImovel(final Long idFinalidadeImovel) {
		jdbcTemplate.update(desabilitarFinalidadeImovel, idFinalidadeImovel);

	}

	public void ativarFinalidadeImovel(final Long idFinalidadeImovel) {
		jdbcTemplate.update(ativarFinalidadeImovel, idFinalidadeImovel);
	}

	public void deletarFinalidadeImovel(final Long idFinalidadeImovel) {
		jdbcTemplate.update(deletarFinalidadeImovel, idFinalidadeImovel);
	}

}