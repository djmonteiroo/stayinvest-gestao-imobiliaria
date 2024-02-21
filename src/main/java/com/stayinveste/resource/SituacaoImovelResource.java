package com.stayinveste.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stayinveste.lib.dto.SituacaoImovelDto;
import com.stayinveste.service.SituacaoImovelService;

@Controller
@RequestMapping("/registrar/situacao-imovel")
public class SituacaoImovelResource {

	@Autowired
	private SituacaoImovelService situacaoImovelService;

	@GetMapping
	public ModelAndView situacaoImovelHome(final SituacaoImovelDto situacaoImovelDto) {
		ModelAndView modelAndView = new ModelAndView("situacaoImovel/registro-situacao-imovel");
		List<SituacaoImovelDto> lsSituacaoImovelDto = situacaoImovelService.consultarSituacaoImoveis();
		modelAndView.addObject("lsSituacaoImovel", lsSituacaoImovelDto);
		return modelAndView;
	}

	@PostMapping("/criar")
	public ModelAndView registrarTipoImovel(final SituacaoImovelDto situacaoImovelDto) {
		
		situacaoImovelService.criarSituacaoImovel(situacaoImovelDto);
		return situacaoImovelHome(situacaoImovelDto);
	}

	@GetMapping("/desativar/{idTipoImovel}")
	public String desabilitarTipoImovel(@PathVariable("idTipoImovel") final Long idTipoImovel) {
		situacaoImovelService.desabilitarSituacaoImovel(idTipoImovel);
		return "redirect:/registrar/situacao-imovel";
	}

	@GetMapping("/ativar/{idTipoImovel}")
	public String habilitarTipoImovel(@PathVariable("idTipoImovel") final Long idTipoImovel) {
		situacaoImovelService.ativarTipoImovel(idTipoImovel);
		return "redirect:/registrar/situacao-imovel";
	}

	@GetMapping("/deletar/{idTipoImovel}")
	public String deletarTipoImovel(@PathVariable("idTipoImovel") final Long idTipoImovel) {
		situacaoImovelService.deletarSituacaoImovel(idTipoImovel);
		return "redirect:/registrar/situacao-imovel";
	}
}