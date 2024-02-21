package com.stayinveste.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.stayinveste.lib.entity.TipoImovelEntity;

@Repository
@PropertySource(value = "classpath:query/tipo-imovel.properties")
public class TipoImovelRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Value("${INSERT.TIPO.IMOVEL}")
	private String inserirTipoImovel;

	@Value("${BUSCAR.TODOS.TIPOS.IMOVEIS}")
	private String buscarTodosTipoImovel;

	@Value("${DESABILITAR.TIPO.IMOVEL}")
	private String desabilitarTipoImovel;

	@Value("${ATIVAR.TIPO.IMOVEL}")
	private String ativarTipoImovel;

	@Value("${DELETAR.TIPO.IMOVEL}")
	private String deletarTipoImovel;

	public void registrarTipoImovel(final TipoImovelEntity tipoImovel) {
		try {
			jdbcTemplate.update(inserirTipoImovel, tipoImovel.getNmTipoImovel(), tipoImovel.getTxDescricao(),
					tipoImovel.getInAtivo(), tipoImovel.getDtInclusao());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public List<TipoImovelEntity> buscarTodos() {
		return jdbcTemplate.query(buscarTodosTipoImovel, new BeanPropertyRowMapper<>(TipoImovelEntity.class));

	}

	public void desabilitarTipoImovel(final Long idTipoImovel) {
		jdbcTemplate.update(desabilitarTipoImovel, idTipoImovel);

	}

	public void ativarTipoImovel(final Long idTipoImovel) {
		jdbcTemplate.update(ativarTipoImovel, idTipoImovel);
	}

	public void deletarTipoImovel(Long idTipoImovel) {
		jdbcTemplate.update(deletarTipoImovel, idTipoImovel);
	}

}
