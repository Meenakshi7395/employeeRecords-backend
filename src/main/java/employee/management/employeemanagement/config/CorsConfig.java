package employee.management.employeemanagement.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        // Read deployed frontend URL from env var set on Render
        String frontendUrl = System.getenv("https://employeerecords-frontend.onrender.com");

        String[] allowedOrigins = (frontendUrl != null && !frontendUrl.isBlank())
                ? new String[]{"http://localhost:4200", frontendUrl}
                : new String[]{"http://localhost:4200"};

        registry.addMapping("/api/**")
                .allowedOrigins(allowedOrigins)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*");
    }
}