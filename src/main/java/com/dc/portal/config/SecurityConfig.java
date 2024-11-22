package com.dc.portal.config;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import com.dc.portal.security.JwtAuthFilter;
import com.dc.portal.security.JwtService;

import graphql.schema.GraphQLScalarType;
import graphql.schema.idl.RuntimeWiring;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

    private JwtService jwtService;

    @Autowired
    @Lazy
    private UserDetailsService userDetailsService;

    public SecurityConfig(JwtService jwtService) {
        super();
        this.jwtService = jwtService;
        LOGGER.info("SecurityConfig initialized with JwtService.");
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        JwtAuthFilter jwtAuthFilter = new JwtAuthFilter();

        LOGGER.info("Configuring SecurityFilterChain...");
        return http
                .cors(cors -> {
                    LOGGER.info("Configuring CORS...");
                    cors.configurationSource(request -> {
                        CorsConfiguration config = new CorsConfiguration();
                        config.addAllowedOrigin("*"); // Use your frontend URL in production
                        config.addAllowedMethod("*");
                        config.addAllowedHeader("*");
                        config.setAllowCredentials(true);
                        LOGGER.debug("CORS Configuration: {}", config);
                        return config;
                    });
                })
                .csrf(csrf -> {
                    LOGGER.info("Disabling CSRF...");
                    csrf.disable();
                })
                .authorizeHttpRequests(auth -> {
                    LOGGER.info("Configuring authorization rules...");
                    auth.requestMatchers(HttpMethod.POST, "/graphql").permitAll() 
                    .requestMatchers("/graphiql").permitAll()  
                    .anyRequest().authenticated(); 
                })
                .sessionManagement(session -> {
                    LOGGER.info("Setting session management policy to STATELESS...");
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                })
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        LOGGER.info("Initializing InMemoryUserDetailsManager...");
        return new InMemoryUserDetailsManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        LOGGER.info("Initializing BCryptPasswordEncoder...");
        return new BCryptPasswordEncoder();
    }
    
    // Add the GraphQL Scalar type configuration for Upload
    @Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurer() {
        return builder -> {
            builder.scalar(GraphQLScalarType.newScalar()
                    .name("Upload")
                    .coercing(new UploadCoercing())
                    .build());
        };
    }
}
