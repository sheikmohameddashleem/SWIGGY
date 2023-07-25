package com.masai.Utils;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
public class AppConfig {

	@Bean
	public SecurityFilterChain configuration(HttpSecurity http) throws Exception {

		http.cors(cors -> {
			cors.configurationSource(new org.springframework.web.cors.CorsConfigurationSource() {

				@Override
				public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
					CorsConfiguration configuration = new CorsConfiguration();
					configuration.setAllowedOriginPatterns(Collections.singletonList("*"));
					configuration.setAllowedMethods(Collections.singletonList("*"));
					configuration.setAllowCredentials(true);
					configuration.setAllowedHeaders(Collections.singletonList("*"));
					configuration.setExposedHeaders(Arrays.asList("Authorization"));
					return configuration;
				}
			});
		}).authorizeHttpRequests(auth -> auth.requestMatchers(HttpMethod.POST, "/CustomerAdd").permitAll()
				.requestMatchers("/swagger-ui*/**", "/v3/api-docs/**").permitAll().requestMatchers("/cus","/order")
				.hasAnyRole("ADMIN", "USER")
				.requestMatchers("/RestaurantUpdate", "/RestaurantAdd", "/Restaurant/{field}/{direction}",
						"/Restaurant/{id}", "/RestaurantDelete/{id}", "/DeliveryPartnerUpdate", "/DeliveryPartnerAdd",
						"/DeliveryPartner/{id}", "/DeliveryPartnerDelete/{id}")
				.hasRole("ADMIN").anyRequest().authenticated()).csrf(csrf -> csrf.disable())
				.formLogin(Customizer.withDefaults()).httpBasic(Customizer.withDefaults());
		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
