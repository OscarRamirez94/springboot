package com.proyecto.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.proyecto.constant.ViewConstant;
import com.proyecto.model.UserCredential;

@Controller
public class LoginController {
	public static final Log LOGGER = LogFactory.getLog(LoginController.class);


	@GetMapping("/")
	public RedirectView redirect() {
		LOGGER.info("METHOD ::: REDIRECTLOGIN ");
		return new RedirectView("/login");
	}

	@GetMapping("/login")
	public String showLoginForm(

			@RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout, Model model) {
		LOGGER.info("METHOD ::: showLoginForm -- PARAMS ::: ERROR = " + error + "LOGOUT = " + logout);
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		model.addAttribute("userCredential", new UserCredential());
		LOGGER.info("RETURN VIEW FORMULARIO LOGIN ");
		return ViewConstant.formularioLogin;
	}

	@PostMapping("/loginCheck")
	public String LoginCheck(@ModelAttribute(name = "userCredential") UserCredential userCredential) {
		LOGGER.info("METHOD ::: LoginCheck -- PARAMS :::  " + userCredential.toString());
		if (userCredential.getUsername().equals("user") && userCredential.getPassword().equals("user")) {
			LOGGER.info("RETURN CONTACTOS");
			return "redirect:/contact/showContacts";
		}
		LOGGER.info("REDIRECT  A LOGIN ERROR");
		return "redirect:/login?error";
	}

}
