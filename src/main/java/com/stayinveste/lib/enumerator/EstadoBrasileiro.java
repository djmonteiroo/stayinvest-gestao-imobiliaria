package com.stayinveste.lib.enumerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum EstadoBrasileiro {
	ACRE(1, "AC", "Acre"), ALAGOAS(2, "AL", "Alagoas"), AMAPA(3, "AP", "Amapá"), AMAZONAS(4, "AM", "Amazonas"),
	BAHIA(5, "BA", "Bahia"), CEARA(6, "CE", "Ceará"), DISTRITO_FEDERAL(7, "DF", "Distrito Federal"),
	ESPIRITO_SANTO(8, "ES", "Espírito Santo"), GOIAS(9, "GO", "Goiás"), MARANHAO(10, "MA", "Maranhão"),
	MATO_GROSSO(11, "MT", "Mato Grosso"), MATO_GROSSO_DO_SUL(12, "MS", "Mato Grosso do Sul"),
	MINAS_GERAIS(13, "MG", "Minas Gerais"), PARA(14, "PA", "Pará"), PARAIBA(15, "PB", "Paraíba"),
	PARANA(16, "PR", "Paraná"), PERNAMBUCO(17, "PE", "Pernambuco"), PIAUI(18, "PI", "Piauí"),
	RIO_DE_JANEIRO(19, "RJ", "Rio de Janeiro"), RIO_GRANDE_DO_NORTE(20, "RN", "Rio Grande do Norte"),
	RIO_GRANDE_DO_SUL(21, "RS", "Rio Grande do Sul"), RONDONIA(22, "RO", "Rondônia"), RORAIMA(23, "RR", "Roraima"),
	SANTA_CATARINA(24, "SC", "Santa Catarina"), SAO_PAULO(25, "SP", "São Paulo"), SERGIPE(26, "SE", "Sergipe"),
	TOCANTINS(27, "TO", "Tocantins");

	private final int id;
	private final String uf;
	private final String nomeCompleto;

	private static final Map<Integer, EstadoBrasileiro> estadoPorId = new HashMap<>();

	static {
		for (EstadoBrasileiro estado : values()) {
			estadoPorId.put(estado.getId(), estado);
		}
	}

	EstadoBrasileiro(int id, String uf, String nomeCompleto) {
		this.id = id;
		this.uf = uf;
		this.nomeCompleto = nomeCompleto;
	}

	public int getId() {
		return id;
	}

	public String getUf() {
		return uf;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public static EstadoBrasileiro getById(int id) {
		return estadoPorId.get(id);
	}

	public static List<EstadoBrasileiro> getAll() {
		List<EstadoBrasileiro> estados = new ArrayList<>();
		for (EstadoBrasileiro estado : values()) {
			estados.add(estado);
		}
		return estados;
	}
}
