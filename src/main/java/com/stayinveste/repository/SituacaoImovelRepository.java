package com.stayinveste.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.stayinveste.lib.entity.SituacaoImovelEntity;

@Repository
@PropertySource(value = "classpath:query/situacao-imovel.properties")
public class SituacaoImovelRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Value("${INSERT.SITUACAO.IMOVEL}")
	private String inserirSituacaoImovel;

	@Value("${BUSCAR.TODAS.SITUACAO.IMOVEIS}")
	private String buscarTodosSituacaoImovel;

	@Value("${DESABILITAR.SITUACAO.IMOVEL}")
	private String desabilitarSituacaoImovel;

	@Value("${ATIVAR.SITUACAO.IMOVEL}")
	private String ativarSituacaoImovel;

	@Value("${DELETAR.SITUACAO.IMOVEL}")
	private String deletarSituacaoImovel;

	public void registrarSituacaoImovel(final SituacaoImovelEntity situacaoImovel) {
		try {
			jdbcTemplate.update(inserirSituacaoImovel, situacaoImovel.getNmSituacaoImovel(), situacaoImovel.getTxDescricao(),
					situacaoImovel.getInAtivo(), situacaoImovel.getDtInclusao());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public List<SituacaoImovelEntity> buscarTodos() {
		return jdbcTemplate.query(buscarTodosSituacaoImovel, new BeanPropertyRowMapper<>(SituacaoImovelEntity.class));

	}

	public void desabilitarSituacaoImovel(final Long idSituacaoImovel) {
		jdbcTemplate.update(desabilitarSituacaoImovel, idSituacaoImovel);

	}

	public void ativarSituacaoImovel(final Long idSituacaoImovel) {
		jdbcTemplate.update(ativarSituacaoImovel, idSituacaoImovel);
	}

	public void deletarSituacaoImovel(Long idSituacaoImovel) {
		jdbcTemplate.update(deletarSituacaoImovel, idSituacaoImovel);
	}

}
