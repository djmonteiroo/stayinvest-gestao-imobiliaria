package com.stayinveste.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stayinveste.lib.dto.TipoImovelDto;
import com.stayinveste.lib.entity.TipoImovelEntity;
import com.stayinveste.service.TipoImovelService;

@Controller
@RequestMapping("/registrar/tipo-imovel")
public class TipoImovelResource {

	@Autowired
	private TipoImovelService tipoImovelService;

	@GetMapping("/criar")
	public ModelAndView tipoImovelHome(final TipoImovelDto tipoImovelDto) {
		ModelAndView modelAndView = new ModelAndView("tipoImovel/registro-tipo-imovel");
		List<TipoImovelDto> lsTipoImovelDto = tipoImovelService.consultarTiposImoveis();
		modelAndView.addObject("lsTipoImovel", lsTipoImovelDto);
		
		return modelAndView;
	}

	@PostMapping("/criar")
	public ModelAndView registrarTipoImovel(final TipoImovelDto tipoImovelDto, final Model model) {
	
		tipoImovelService.criarTipoImovel(tipoImovelDto);
		ModelAndView telaTipoImovel = new ModelAndView("tipoImovel/registro-tipo-imovel");
		telaTipoImovel.addObject("tipoImovel", tipoImovelDto);
		
		model.addAttribute("mensagem", "Novo tipo cadastrado com Sucesso!");
		model.addAttribute("tipo", "sucesso");
		return telaTipoImovel;
	}

}