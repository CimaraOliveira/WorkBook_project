package com.workbook.WorkBook_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.workbook.WorkBook_project.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	
	@Query("select r from Role r where r.nome = ?1")
	public Role findByNome(String nome);

}
