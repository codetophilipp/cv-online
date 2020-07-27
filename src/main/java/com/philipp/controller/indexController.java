package com.philipp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.philipp.model.Usuario;
import com.philipp.repository.UsuarioRepository;

@Controller
public class indexController {
	
	@Autowired
	UsuarioRepository ur;
	
	@RequestMapping("/")
	public String index() {
		return "index";
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
}
