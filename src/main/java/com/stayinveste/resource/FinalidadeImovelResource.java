package com.stayinveste.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stayinveste.lib.dto.FinalidadeImovelDto;
import com.stayinveste.service.FinalidadeImovelService;

@Controller
@RequestMapping("registrar/finalidade-imovel")
public class FinalidadeImovelResource {

	@Autowired
	private FinalidadeImovelService service;

	@GetMapping
	public ModelAndView finalidadeImovelHome(final FinalidadeImovelDto finalidadeImovelDto) {
		ModelAndView regiaoTela = new ModelAndView("finalidadeImovel/registro-finalidade-imovel");
		regiaoTela.addObject("lsFinalidade", service.consultarFinalidadeImoveis());
		return regiaoTela;
	}

	@PostMapping("/criar")
	public ModelAndView registrarFinalidadeImovel(final FinalidadeImovelDto finalidadeImovelDto) {
		service.criarFinalidadeImovel(finalidadeImovelDto);
		return finalidadeImovelHome(finalidadeImovelDto);
	}

	@GetMapping("/desativar/{idFinalidadeImovel}")
	public String desabilitarRegiaoImovel(@PathVariable("idFinalidadeImovel") final Long idFinalidadeImovel) {
		service.desabilitarFinalidadeImovel(idFinalidadeImovel);
		return "redirect:/registrar/finalidade-imovel";
	}

	@GetMapping("/ativar/{idFinalidadeImovel}")
	public String habilitarTipoImovel(@PathVariable("idFinalidadeImovel") final Long idFinalidadeImovel) {
		service.ativarFinalidadeImovel(idFinalidadeImovel);
		return "redirect:/registrar/finalidade-imovel";
	}

	@GetMapping("/deletar/{idFinalidadeImovel}")
	public String deletarRegiaoImovel(@PathVariable("idFinalidadeImovel") final Long idFinalidadeImovel) {
		service.deletarFinalidadeImovel(idFinalidadeImovel);
		return "redirect:/registrar/finalidade-imovel";
	}
}