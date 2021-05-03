package com.workbook.WorkBook_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@GetMapping("/cadastrar")
	public String cadastro() {
		return "/usuario/cadastro";
	}

}
