package com.stayinveste.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stayinveste.lib.dto.ImovelDto;
import com.stayinveste.service.CadastroImovelService;

@Controller
public class CadastroImovelResource {

	@Autowired
	private CadastroImovelService service;

	@GetMapping("/registrar-imovel")
	public ModelAndView chamarTela(final ImovelDto imovel) {
		ModelAndView modelAndView = new ModelAndView("registrar-imovel");
		modelAndView.addObject("imovel", imovel);
		return modelAndView;
	}

	@PostMapping("/registrar-imovel")
	public String registrarImovel(final ImovelDto imovel) {
		ModelAndView modelAndView = new ModelAndView("registrar-imovel");
		service.registrarImovel(imovel);
		modelAndView.addObject("imovel", imovel);

		return "redirect:/";
	}

	@GetMapping("/deletar/{id}")
	public String deletarImovel(@PathVariable("id")Long id) {
//		service.removerImovel(id);
		return "redirect:/";
	}

//	@GetMapping("/editar/{id}")
//	public ModelAndView editarImovel(@PathVariable("id")Long id) {
////		ImovelDto editarImovel = service.editarImovel(id);
//		ModelAndView mav = new ModelAndView("editar-imovel");
////		mav.addObject("imovel", editarImovel);
//		return mav;
//	}

//	@PostMapping("/editar-imovel/{id}")
//	public String editarImovelPersiste(@PathVariable("id")Long id, ImovelDto dto) {
////		service.editarImovelPersiste(id, dto);
////		ModelAndView mav = new ModelAndView("editar-imovel");
////		mav.addObject("imovel", editarImovel);
//		return "redirect:/";
//	}
}
