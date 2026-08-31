package com.ingenieriaSoftware2.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;


import java.util.Arrays;

@Configuration
public class CorsConfig {
    @Bean
    @Primary
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        // ✅ Orígenes permitidos (frontend)
        configuration.setAllowedOrigins(Arrays.asList(
                "http://localhost:5173",  // Vite (React, Vue)
                "http://localhost:3000",  // React Create-React-App
                "http://localhost:4200",  // Angular
                "http://localhost:8080"   // Otros
        ));

        // ✅ Métodos HTTP permitidos
        configuration.setAllowedMethods(Arrays.asList(
                "GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS"
        ));

        // ✅ Headers permitidos
        configuration.setAllowedHeaders(Arrays.asList(
                "Authorization",
                "Content-Type",
                "Accept",
                "X-Requested-With",
                "Origin",
                "Access-Control-Request-Method",
                "Access-Control-Request-Headers"
        ));

        // ✅ Headers expuestos al frontend
        configuration.setExposedHeaders(Arrays.asList(
                "Authorization",
                "Content-Type"
        ));

        // ✅ Permitir credenciales (cookies, tokens)
        configuration.setAllowCredentials(true);

        // ✅ Tiempo de caché de CORS (1 hora)
        configuration.setMaxAge(3600L);

        // ✅ Aplicar configuración a todas las rutas
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return (CorsConfigurationSource) source;
    }
}
