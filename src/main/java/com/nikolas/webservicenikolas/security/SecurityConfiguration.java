package com.nikolas.webservicenikolas.security;


import com.nikolas.webservicenikolas.security.provider.ApiKeyProvider;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
@AllArgsConstructor
public class SecurityConfiguration {

    private final ApiKeyProvider apiKeyProvider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        ApiKeyAuthenticationFilter filter = new ApiKeyAuthenticationFilter();
        AuthenticationManager authManager = this.authenticationManagerBean();
        filter.setAuthenticationManager(authManager);
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/**"))
                .sessionManagement(sess -> sess
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilter(filter).authorizeHttpRequests(requests -> requests.requestMatchers("/**").permitAll());
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManagerBean() {
        return new ApiKeyAuthenticationManager(apiKeyProvider);
    }
}