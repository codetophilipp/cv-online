package com.philipp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.philipp.model.Usuario;
import com.philipp.repository.UsuarioRepository;

@Controller
public class IndexController {
	
	@Autowired
	UsuarioRepository ur;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/projeto")
	public String projeto() {
		return "projeto";
	}
	
	@RequestMapping(value="/mural", method = RequestMethod.POST)
	public String salvar(Usuario usuario) {
		ur.save(usuario);
		return "redirect:mural";
	}
	
	@RequestMapping(value="/mural", method = RequestMethod.GET)
	public ModelAndView listaMensagens() {
		Iterable<Usuario> usuario = ur.findAll();
		ModelAndView mv = new ModelAndView("mural");
		mv.addObject("usuarios", usuario);
		return mv;
	}
	
	@RequestMapping(value="/mural-detalhes/{id}", method = RequestMethod.GET)
	public ModelAndView detalhaMensagem(@PathVariable("id") Long id) {
		Usuario usuario = ur.findById(id);
		ModelAndView mv = new ModelAndView("mural-detalhes");
		mv.addObject("usuario", usuario);
		return mv;
	}
}
