package com.workbook.WorkBook_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workbook.WorkBook_project.model.Role;
import com.workbook.WorkBook_project.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	public void save(Role role) {
		roleRepository.saveAndFlush(role);
	}
	
	public Role getNome(String nome) {
		return roleRepository.findByNome(nome);
	}
	
	public List<Role> buscarTodos(){
		return roleRepository.findAll();
	}
}
