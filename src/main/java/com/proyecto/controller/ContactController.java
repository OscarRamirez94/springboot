package com.proyecto.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.proyecto.constant.ViewConstant;
import com.proyecto.entity.Contact;
import com.proyecto.model.ContactModel;
import com.proyecto.service.ContactService;

@Controller
@RequestMapping("/contact")
public class ContactController {
	@Autowired
	@Qualifier("contactServiceImpl")
	private ContactService contactService;
	public static final Log LOGGER = LogFactory.getLog(ContactController.class);

	@GetMapping("/")
	public RedirectView redirect() {
		return new RedirectView("/contact/mostrarFormulario");
	}

	@GetMapping("/cancel")
	public String redirectCancel() {
		return "redirect:/contact/showContacts";
	}

	@GetMapping("/mostrarFormulario")
	public String mostrarFormulario(@RequestParam(name = "id", required = false) int id, Model model) {
		ContactModel contact = new ContactModel();
		if (id != 0) {
			contact = contactService.findByIdModel(id);
		}

		model.addAttribute("contactModel", contact);

		return ViewConstant.formularioContacto;
	}

	@PostMapping("/addContact")
	public String addContact(@ModelAttribute(name = "contactModel") ContactModel contactModel, Model model) {
		LOGGER.info("METHOD ::: addContact -- PARAMS :::  " + contactModel.toString());

		if (null != contactService.addContact(contactModel)) {
			model.addAttribute("result", 1);
			return "redirect:/contact/showContacts";
		} else {
			model.addAttribute("result", 0);
		}

		return "redirect:/contact/showContacts";
	}

	@GetMapping("/showContacts")
	public ModelAndView showContacts() {
		ModelAndView mav = new ModelAndView(ViewConstant.Contacts);
		mav.addObject("contacts", contactService.listAllContact());
		return mav;
	}

	@GetMapping("/deleteContact")
	public ModelAndView deleteContact(@RequestParam(name = "id", required = true) int id) {
		ModelAndView mav = new ModelAndView(ViewConstant.Contacts);
		contactService.deleteId(id);
		mav.addObject("contacts", contactService.listAllContact());
		return mav;
	}

	@GetMapping("/updateContact")
	public ModelAndView updateContact(@RequestParam(name = "id", required = true) int id) {
		ModelAndView mav = new ModelAndView(ViewConstant.Contacts);

		return mav;
	}

}
