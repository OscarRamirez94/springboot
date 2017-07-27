package com.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.proyecto.service.ExampleService;
@Controller
@RequestMapping("/hola")
public class HolamundoController {
	@Autowired
	@Qualifier("exampleService")
	private ExampleService  exampleService ;
	
	@GetMapping("/holamundo")
	public String Holamundo(Model model) {
		
		model.addAttribute("people", exampleService.getPeople());
		return "helloworld";
	}
	
	@GetMapping("/holamundoModel")
	public ModelAndView holaModelAndView() {
		ModelAndView mav= new ModelAndView("helloworld");
		mav.addObject("people",exampleService.getPeople());
	return mav;
}
	
}
