package com.creditoptimizer.backend_creditoptimizer.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Aplica a todos los endpoints
                .allowedOrigins("http://localhost:5173") // El puerto exacto donde corre tu Vue/Vite
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // OPTIONS es vital para evitar el status 500
                .allowedHeaders("*")
                .allowCredentials(true); // Opcional, necesario si envías cookies o tokens en sesión
    }
}