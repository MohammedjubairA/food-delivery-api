package com.example.demowithswiggy.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	@Autowired
	CustomerUserDetailsService cs;
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http)throws Exception
	{
		http
		.csrf(csrf->csrf.disable())
		.authorizeHttpRequests(auth->auth
				.requestMatchers("/auth/**").permitAll()
				.requestMatchers("/admin/**").hasRole("ADMIN")
				.requestMatchers("/customer/**").hasRole("CUSTOMER")
				.requestMatchers("/delivery/**").hasRole("DELIVERY_PARTNER")
				.anyRequest().authenticated()
				)
		.httpBasic(Customizer.withDefaults());
		return http.build();
		
				
						 
						
	}
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	} 
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider(cs);
		
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}
}
