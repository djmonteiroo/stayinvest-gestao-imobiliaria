package com.stayinveste.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.stayinveste.lib.dto.ImovelDto;

@Service
public class CadastroImovelService {

	List<ImovelDto> lsImoveis = new ArrayList<ImovelDto>();

	public void registrarImovel(ImovelDto imovel) {
//		imovel.setId(criarId());
		lsImoveis.add(imovel);
	}

	public List<ImovelDto> buscarImoveis() {
//		if (lsImoveis.isEmpty()) {
//			ImovelDto imovelDto = new ImovelDto();
//			imovelDto.setCodigoImovel(criarId());
//			imovelDto.setIdTipoImovel(1);
//			imovelDto.setNmImovel("Flat");
//			imovelDto.setVlImovel(100.00);
//
//			ImovelDto imovelDto2 = new ImovelDto();
//			imovelDto2.setId(criarId());
//			imovelDto2.setIdTipoImovel(1);
//			imovelDto2.setNmImovel("Duplex");
//			imovelDto2.setVlImovel(100.00);
//
//			lsImoveis.add(imovelDto);
//			lsImoveis.add(imovelDto2);
//		}

		return lsImoveis;
	}

	private Long criarId() {
		Random random = new Random();
		Long id = 0L;
		do {
			id = Long.valueOf(random.nextInt());
		} while (id <= 0);

		return id;
	}

//	public void removerImovel(Long id) {
//		lsImoveis.removeIf(i -> i.getId().equals(id));
//	}

//	public ImovelDto editarImovel(Long id) {
//		return lsImoveis.stream().filter(i -> i.getId().equals(id)).findFirst().get();
//	}

//	public void editarImovelPersiste(Long id, ImovelDto imovel) {
//		lsImoveis.stream()
//		.filter(m -> m.getId().equals(id))
//		.findAny()
//		.map(m -> {
//			m.setIdTipoImovel(imovel.getIdTipoImovel());
//			m.setNmImovel(imovel.getNmImovel());
//			m.setVlImovel(imovel.getVlImovel());
//			return m;
//		}).orElseGet(() -> {
//			lsImoveis.add(new ImovelDto(imovel));
//			return null;
//		});
//	}
}