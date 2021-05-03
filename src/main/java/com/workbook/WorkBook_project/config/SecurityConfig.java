package com.workbook.WorkBook_project.config;

import javax.annotation.security.PermitAll;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// acessos publicos liberados
		http.authorizeRequests()
			
			   .antMatchers("/vendor/**", "/css/**", "/images/**", "/js/**").permitAll()
			   .antMatchers("/static/**").permitAll()
			   .antMatchers("/resources/**").permitAll()
			   .antMatchers("/css/**").permitAll()
			   .antMatchers("/js/**").permitAll()
			   

		
			.anyRequest().authenticated()
			.and()
			   .formLogin()
			   .loginPage("/")
			   .defaultSuccessUrl("/home", true)
			   .failureUrl("/login-error")
			   .permitAll() 
			 .and()
			 	.logout()
			 	.logoutSuccessUrl("/");
			   
	}
	
	

}
