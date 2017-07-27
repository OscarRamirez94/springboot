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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import com.proyecto.entity.Course;
import com.proyecto.service.CourseService;

@Controller
@RequestMapping("/Course")
public class CourseController {

	public static final String coursesTemplate = "Courses";
	public static final String coursesformTemplate = "Form";
	private final Log LOGGER = LogFactory.getLog(CourseController.class);
	@Autowired
	@Qualifier("courseServiceImpl")
	private CourseService courseService;

	@GetMapping("/")
	public RedirectView redirect() {
		return new RedirectView("/Course/mostrarFormulario");
	}

	@GetMapping("/mostrarFormulario")
	public String mostrarFormulario(Model model) {
		model.addAttribute("course", new Course());
		return coursesformTemplate;
	}

	@GetMapping("/allCourses")
	public ModelAndView listAllCourse() {
		LOGGER.info("Se ah llamado " + " listAllCourse()" + " controller");
		ModelAndView mav = new ModelAndView(coursesTemplate);
		mav.addObject("courses", courseService.getAllCourse());

		return mav;
	}

	@PostMapping("/addCourse")
	public String addCourse(@ModelAttribute("course") Course course, Model model) {
		LOGGER.info("Se ah llamado " + " addCourse() " + " controllerr" + "Paramams --> " + course.toString());

		courseService.addCourse(course);
		return "redirect:/Course/allCourses";
	}
	@PostMapping("/updatCourse")
	public String updateCourse(@ModelAttribute("course") Course course, Model model) {
		LOGGER.info("Se ah llamado " + " updateCourse() " + " controllerr" + "Paramams --> " + course.toString());

		courseService.updateCourse(course);
		return "redirect:/Course/allCourses";
	}

}
