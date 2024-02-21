package com.stayinveste.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stayinveste.lib.dto.RegiaoImovelDto;
import com.stayinveste.service.RegiaoImovelService;

@Controller
@RequestMapping("registrar/regiao-imovel")
public class RegiaoImovelResource {

	@Autowired
	private RegiaoImovelService service;

	@GetMapping
	public ModelAndView regiaoImovelHome(final RegiaoImovelDto regiaoImovelDto) {
		ModelAndView regiaoTela = new ModelAndView("regiaoImovel/registro-regiao-imovel");
		regiaoTela.addObject("lsRegiao", service.consultarRegiaoImoveis());
		return regiaoTela;
	}

	@PostMapping("/criar")
	public ModelAndView registrarRegiaoImovel(final RegiaoImovelDto regiaoImovelDto) {
		service.criarRegiaoImovel(regiaoImovelDto);
		return regiaoImovelHome(regiaoImovelDto);
	}

	@GetMapping("/desativar/{idRegiaoImovel}")
	public String desabilitarRegiaoImovel(@PathVariable("idRegiaoImovel") final Long idRegiaoImovel) {
		service.desabilitarRegiaoImovel(idRegiaoImovel);
		return "redirect:/registrar/regiao-imovel";
	}

	@GetMapping("/ativar/{idRegiaoImovel}")
	public String habilitarTipoImovel(@PathVariable("idRegiaoImovel") final Long idRegiaoImovel) {
		service.ativarRegiaoImovel(idRegiaoImovel);
		return "redirect:/registrar/regiao-imovel";
	}

	@GetMapping("/deletar/{idRegiaoImovel}")
	public String deletarRegiaoImovel(@PathVariable("idRegiaoImovel") final Long idRegiaoImovel) {
		service.deletarRegiaoImovel(idRegiaoImovel);
		return "redirect:/registrar/regiao-imovel";
	}
}