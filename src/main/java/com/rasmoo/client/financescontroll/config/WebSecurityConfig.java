package com.rasmoo.client.financescontroll.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	public void configuracaoGlobal(AuthenticationManagerBuilder auth) throws Exception{
//		PasswordEncoder pass = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//		auth.inMemoryAuthentication().withUser("felipe").password(pass.encode("finances")).roles("ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		String[] allowed = new String[] {
				"/webjars", "/api/v1/usuario","/static/**"
		};
		
		http.csrf().disable().authorizeRequests()
			.antMatchers(allowed).permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();
	}
	
}
