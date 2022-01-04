package com.example.soldLites.security;



import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.context.annotation.Bean;


@Configuration 
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder().encode("1234")).roles("ADMIN","USER"); //.and()
		auth.inMemoryAuthentication().withUser("user").password(passwordEncoder().encode("1234")).roles("USER");
		
	}

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin(); //.loginPage("/login");
		http.authorizeRequests().antMatchers( "/fournisseur").hasRole(" ADMIN");
		http.authorizeRequests().antMatchers("/saveRayon").hasRole("USER");
		http.exceptionHandling().accessDeniedPage("/403");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
