package com.stayinveste.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.stayinveste.lib.entity.RegiaoImovelEntity;

@Repository
@PropertySource(value = "classpath:query/regiao-imovel.properties")
public class RegiaoImovelRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Value("${INSERT.REGIAO.IMOVEL}")
	private String inserirRegiaoImovel;

	@Value("${BUSCAR.TODAS.REGIOES.IMOVEIS}")
	private String buscarTodasRegioesImovel;

	@Value("${DESABILITAR.REGIAO.IMOVEL}")
	private String desabilitarRegiaoImovel;

	@Value("${ATIVAR.REGIAO.IMOVEL}")
	private String ativarRegiaoImovel;

	@Value("${DELETAR.REGIAO.IMOVEL}")
	private String deletarRegiaoImovel;

	public void registrarRegiaoImovel(final RegiaoImovelEntity regiaoImovel) {
		try {
			jdbcTemplate.update(inserirRegiaoImovel, regiaoImovel.getNmRegiaoImovel(), regiaoImovel.getInAtivo(),
					regiaoImovel.getDtInclusao());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public List<RegiaoImovelEntity> buscarTodos() {
		return jdbcTemplate.query(buscarTodasRegioesImovel, new BeanPropertyRowMapper<>(RegiaoImovelEntity.class));

	}

	public void desabilitarRegiaoImovel(final Long idRegiaoImovel) {
		jdbcTemplate.update(desabilitarRegiaoImovel, idRegiaoImovel);

	}

	public void ativarRegiaoImovel(final Long idRegiaoImovel) {
		jdbcTemplate.update(ativarRegiaoImovel, idRegiaoImovel);
	}

	public void deletarRegiaoImovel(final Long idRegiaoImovel) {
		jdbcTemplate.update(deletarRegiaoImovel, idRegiaoImovel);
	}

}
