package com.proyecto.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class errorsController {
	@ExceptionHandler(Exception.class)
	public String InternalServerError() {
		return "error/505";
	}
}
