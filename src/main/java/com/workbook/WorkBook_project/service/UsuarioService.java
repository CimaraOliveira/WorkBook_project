package com.workbook.WorkBook_project.service;

import java.util.Collection;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.workbook.WorkBook_project.model.Role;
import com.workbook.WorkBook_project.model.Usuario;
import com.workbook.WorkBook_project.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	

	/*@Autowired
	private PasswordEncoder passwordEncoder;*/
	
	@Transactional(readOnly = false)
	public void salvar(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	@Transactional(readOnly = false)
	public void salvarCadastro(Usuario user){
		String crypt = new BCryptPasswordEncoder().encode(user.getSenha());
		user.setSenha(crypt);
		usuarioRepository.save(user);		
	}
		
	
	@Transactional(readOnly = true)
	public Usuario getEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username);
		UserDetails user = usuarioRepository.findByEmail(username);
		org.springframework.security.core.userdetails.User userFinal = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getPermissoes(user));
        System.out.println(userFinal.getAuthorities());
       
		return userFinal;
	}

	private Collection<? extends GrantedAuthority> getPermissoes(UserDetails user) {
    Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		
		Set<Role> permissoes =  ((Usuario) user).getRole();
		for(Role r : permissoes ) {
			 authorities.add(new SimpleGrantedAuthority(r.getNome().toUpperCase()));
		}
		
		return authorities;
	}

}
