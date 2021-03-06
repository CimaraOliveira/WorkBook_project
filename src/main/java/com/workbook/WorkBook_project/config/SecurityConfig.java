package com.workbook.WorkBook_project.config;

import javax.annotation.security.PermitAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// acessos publicos liberados
		/*http.authorizeRequests()
			
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
			 	.logoutSuccessUrl("/");*/
			   
	}
	
	@Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	

}
