package com.masai;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class appConfig {
	
//	@Bean
//	public SecurityFilterChain masaiSecurityConfiguration(HttpSecurity http) throws Exception {
//		
//		http.authorizeHttpRequests((auth)-> auth.requestMatchers("/Customers").permitAll());
//		http.authorizeHttpRequests((auth)-> auth.requestMatchers("/Orders").authenticated()).csrf(csrf -> csrf.disable())
//		.formLogin(Customizer.withDefaults());
//		return http.build();
//	}

}
