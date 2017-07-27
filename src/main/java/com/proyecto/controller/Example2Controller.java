package com.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example2")
public class Example2Controller {
	@GetMapping("/request2/{nm}")
	public ModelAndView holaModelAndView(@PathVariable("nm") String name) {
		ModelAndView mav= new ModelAndView("example");
		mav.addObject("nminmodel",name);
	return mav;
}
	
	

}
