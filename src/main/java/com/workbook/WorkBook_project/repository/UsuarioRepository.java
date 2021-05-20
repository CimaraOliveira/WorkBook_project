package com.workbook.WorkBook_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.workbook.WorkBook_project.model.Usuario;



@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	//@Query("select u from usuario u where u.email like :email")
	Usuario findByEmail(@Param("email")String email);
	
	Usuario findByNome(String username);

}
