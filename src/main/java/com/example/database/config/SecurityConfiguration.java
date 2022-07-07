package com.example.database.config;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity 
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		PasswordEncoder encoder=PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.jdbcAuthentication().dataSource(dataSource)
		.withUser("gourav").password(encoder.encode("12345")).roles("OFFICE_ADMIN")
		.and()
		.withUser("akshay").password(encoder.encode("54321")).roles("OFFICE_MANGER")
		.and()
		.withUser("meena").password(encoder.encode("123")).roles("OFFICE_HR");
	}
	
	
//	@Bean
//	PasswordEncoder encoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().disable();
		http.csrf().disable();
		
		http.authorizeRequests()
		.antMatchers("/office").permitAll()
		.antMatchers("/employee/**").hasRole("OFFICE_ADMIN")
		.antMatchers("/address/**").hasAnyRole("OFFICE_MANAGER","OFFICE_ADMIN")
		.and()
		.exceptionHandling().accessDeniedPage("/office/accessDenied");
		super.configure(http);
	}
}
