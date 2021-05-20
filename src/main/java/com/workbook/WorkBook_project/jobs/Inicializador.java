package com.workbook.WorkBook_project.jobs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.workbook.WorkBook_project.enums.TipoUsuario;
import com.workbook.WorkBook_project.model.Role;
import com.workbook.WorkBook_project.model.Usuario;
import com.workbook.WorkBook_project.service.RoleService;
import com.workbook.WorkBook_project.service.UsuarioService;

@Component
public class Inicializador implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private RoleService roleService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("|*************************************|");
		System.out.println("	Jobs - Initializing User		");
		System.out.println("|*************************************|");
		
		Role roleUser = roleService.getNome("USER");	
		
		if(roleUser == null) {
			roleUser = new Role();
			roleUser.setNome("USUARIO");
			roleService.save(roleUser);	
			
			Usuario cliente = new Usuario();
			cliente.setNome("Cleo");
			cliente.setEmail("cleo@gmail.com");
			cliente.setSenha("123123");
			cliente.setTipo(TipoUsuario.CLIENTE);
			cliente.setTelefone("849999127777");
						
			cliente.getRole().add(roleUser);
			
			usuarioService.salvarCadastro(cliente);
		}
		   
		Role roleAdmin = roleService.getNome("ADMIN");
		if(roleAdmin == null) {
			roleAdmin = new Role();
			roleAdmin.setNome("ADMIN");
			roleService.save(roleAdmin);	
			
			Usuario administrador = new Usuario();
			administrador.setNome("Cimara");
			administrador.setEmail("cimara@gmail.com");			
			administrador.setSenha("12345");
			administrador.setTipo(TipoUsuario.PRIFISSIONAL);
			administrador.getRole().add(roleAdmin);			
			usuarioService.salvarCadastro(administrador);
		}
		
		
	}
	
	

}
