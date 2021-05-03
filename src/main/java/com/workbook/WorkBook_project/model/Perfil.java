package com.workbook.WorkBook_project.model;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "perfis")
public class Perfil {
	
	@Id
	private Long id;
	
	private String nome;
	
	/*@OneToMany(mappedBy = "perfil")
	private List<Categoria> categorias;*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	/*public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}	*/

}

