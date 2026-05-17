package com.jbs.posbe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class SecurityConfig {

	// =====================================================
	// SECURITY FILTER CHAIN
	// =====================================================

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http

			// ENABLE CORS
			.cors(cors -> cors.configurationSource(corsConfigurationSource()))

			// DISABLE CSRF
			.csrf(csrf -> csrf.disable())

			// AUTHORIZE REQUESTS
			.authorizeHttpRequests(auth -> auth.anyRequest().permitAll());

		return http.build();
	}

	// =====================================================
	// CORS CONFIGURATION
	// =====================================================

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {

		CorsConfiguration configuration = new CorsConfiguration();

		// FRONTEND URL

		configuration.setAllowedOrigins(List.of("http://localhost:5173"));

		// ALLOWED METHODS

		configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS"));

		// ALLOWED HEADERS

		configuration.setAllowedHeaders(List.of("*"));

		// ALLOW CREDENTIALS

		configuration.setAllowCredentials(true);

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

		source.registerCorsConfiguration("/**", configuration);

		return source;
	}

}
