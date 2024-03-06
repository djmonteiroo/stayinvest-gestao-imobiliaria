package com.stayinveste.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.stayinveste.lib.dto.TipoImovelDto;
import com.stayinveste.service.TipoImovelService;

@RestController
@RequestMapping("/registrar/tipo-imovel")
public class TipoImovelResource {

	@Autowired
	private TipoImovelService tipoImovelService;

	@GetMapping
	public List<TipoImovelDto> tipoImovelHome(final TipoImovelDto tipoImovelDto) {
//		ModelAndView modelAndView = new ModelAndView("tipoImovel/registro-tipo-imovel");
		return tipoImovelService.consultarTiposImoveis();
//		modelAndView.addObject("lsTipoImovel", lsTipoImovelDto);
//		modelAndView.addObject("tipoImovel", new TipoImovelDto());
//		return modelAndView;
	}

	@PostMapping("/criar")
	public ModelAndView registrarTipoImovel(final TipoImovelDto tipoImovelDto) {

		tipoImovelService.criarTipoImovel(tipoImovelDto);
//		return tipoImovelHome(tipoImovelDto);
		return null;
	}

	@GetMapping("/desativar/{idTipoImovel}")
	public String desabilitarTipoImovel(@PathVariable("idTipoImovel") final Long idTipoImovel) {
		tipoImovelService.desabilitarTipoImovel(idTipoImovel);
		return "redirect:/registrar/tipo-imovel";
	}

	@GetMapping("/ativar/{idTipoImovel}")
	public String habilitarTipoImovel(@PathVariable("idTipoImovel") final Long idTipoImovel) {
		tipoImovelService.ativarTipoImovel(idTipoImovel);
		return "redirect:/registrar/tipo-imovel";
	}

	@GetMapping("/deletar/{idTipoImovel}")
	public String deletarTipoImovel(@PathVariable("idTipoImovel") final Long idTipoImovel) {
		tipoImovelService.deletarTipoImovel(idTipoImovel);
		return "redirect:/registrar/tipo-imovel";
	}
}