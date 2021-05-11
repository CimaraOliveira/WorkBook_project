package com.workbook.WorkBook_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	/*@GetMapping("/")
	public String index() {
		return "/index";
	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/login")
	public String login() {
		return "/login";
	}
	
	//login inválido
	@GetMapping("/login-error")
	public String loginError(ModelMap model) {
		model.addAttribute("alerta", "erro");
		model.addAttribute("titulo", "Dados Inválidos!");
		model.addAttribute("texto", "Email ou Senha incorretos tente novamente!");
		model.addAttribute("subtexto", "Acesso permitido apenas para cadastros já ativados!");
		return "/login";
	}*/

}
