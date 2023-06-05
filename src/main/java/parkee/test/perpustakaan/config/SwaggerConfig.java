package parkee.test.perpustakaan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI myOpenAPI() {

        final String securitySchemeName = "bearerAuth";
        Contact contact = new Contact();
        contact.setEmail("yudiwidiawan@gmail.com");
        contact.setName("Yudi Widiawan");
        contact.setUrl("https://www.github.com/yudiwidiawan");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("Perpustakan Management API")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints to manage library (perpustakaan).")
                .termsOfService("https://www.bezkoder.com/terms")
                .license(mitLicense);

        return new OpenAPI().info(info).addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
                .components(new Components().addSecuritySchemes(securitySchemeName,
                        new SecurityScheme().name(securitySchemeName).type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")));
    }
}
