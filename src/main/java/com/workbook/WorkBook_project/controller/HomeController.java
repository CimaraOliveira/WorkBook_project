package com.workbook.WorkBook_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String inicio() {
		return "/inicio";
	}
	
	@GetMapping("/home")
	public String home() {
		return "/home";
	}

}
