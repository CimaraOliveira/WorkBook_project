package com.workbook.WorkBook_project.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.workbook.WorkBook_project.model.Usuario;
import com.workbook.WorkBook_project.service.RoleService;
import com.workbook.WorkBook_project.service.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping("/cadastrar")
	public String cadastro() {
		return "/usuario/cadastro";
	}
	
	@PostMapping("/salvar") 
	public String salvar(@Valid Usuario usuario,BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) { 
			return "usuario/cadastro";
		}
		//Usuario u = usuarioService.getEmail(user.getEmail());
		
			//String senha = user.getSenha();
			//user.setSenha(new BCryptPasswordEncoder().encode(senha));
			usuarioService.salvar(usuario);
			attr.addFlashAttribute("success", "Usuário Cadastrado com sucesso!");
			 
		
		return "redirect:/usuario/cadastrar";
	} 

}
