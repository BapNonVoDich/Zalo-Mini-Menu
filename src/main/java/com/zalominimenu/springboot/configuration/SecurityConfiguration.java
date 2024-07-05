package com.zalominimenu.springboot.configuration;

import com.zalominimenu.springboot.security.jwt.JwtAuthenticationFilter;
import com.zalominimenu.springboot.security.jwt.JwtAuthenticationEntryPoint;
import com.zalominimenu.springboot.security.jwt.CustomerJwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {

	private final JwtAuthenticationFilter jwtAuthenticationFilter;

	private final JwtAuthenticationEntryPoint unauthorizedHandler;

	private final CustomerJwtAuthenticationFilter userIdValidationFilter;
	@Bean
	public AuthenticationManager authenticationManager(final AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	@Order(1)
	public SecurityFilterChain securityFilterChainAdminPortal(HttpSecurity http) throws Exception {
		return http.securityMatcher("/v1/admin-portal/**")
				.authorizeHttpRequests(authorize -> authorize
						.requestMatchers("/health", "/v1/admin-portal/auth/login", "/v3/api-docs/**",
								"/swagger-ui/**", "/swagger-ui.html", "/actuator/**").permitAll()
						.anyRequest().authenticated()
				)
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.csrf(AbstractHttpConfigurer::disable) // Disable CSRF
				.cors(AbstractHttpConfigurer::disable)  // Disable CORS or configure as needed
				.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
				.exceptionHandling(exceptions -> exceptions.authenticationEntryPoint(unauthorizedHandler)).build();
	}

	@Bean
	@Order(1)
	public SecurityFilterChain securityFilterChainCustomerPortal(HttpSecurity http) throws Exception {
		http
				.securityMatcher("/v1/customer-portal/**")
				.authorizeHttpRequests(authorize -> authorize
						.requestMatchers("/v1/customer-portal/auth/get-token").permitAll()
						.anyRequest().authenticated()
				)
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.csrf(AbstractHttpConfigurer::disable) // Disable CSRF for this stateless API
				.cors(AbstractHttpConfigurer::disable)  // Disable CORS or configure as needed
				.addFilterBefore(userIdValidationFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}
}
