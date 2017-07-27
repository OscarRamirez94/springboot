package com.proyecto.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.proyecto.model.Person;



@Controller
@RequestMapping("/example3")
public class Example3Controller {
	
	@GetMapping("/")
	public RedirectView redirect() {
		return new RedirectView("/example3/mostrarformulario");
	}
	@GetMapping("/mostrarformulario")
	public String mostrarFormulario(Model model) {
	model.addAttribute("person", new Person());
		return "formulario";
	}
	@PostMapping("/addPerson")
	public ModelAndView addPerson(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult) {
		ModelAndView mav = new ModelAndView();
		if(bindingResult.hasErrors()) 
		{
		mav.setViewName("formulario");
		}else
		{
		mav.setViewName("resultado");
		mav.addObject("person", person);
		}
		return mav;
	}
	
}