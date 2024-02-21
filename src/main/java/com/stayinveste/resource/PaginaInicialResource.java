package com.stayinveste.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stayinveste.service.CadastroImovelService;

@Controller
public class PaginaInicialResource {

	@Autowired
	private CadastroImovelService service;

	@GetMapping("/")
	public ModelAndView paginaInicial() {
		ModelAndView dashboard = new ModelAndView("dashboard");
		dashboard.addObject("titulo", "Listagem de Imóveis");
		dashboard.addObject("listaImoveis", service.buscarImoveis());

		return dashboard;
	}

}

