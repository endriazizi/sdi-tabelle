package it.iccs.simeal.sdi.tabelle.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "Sdi Configurazione Service API", version = "0.1.0"))
//@OpenAPIDefinition(info = @Info(title = "Sdi Configurazione Service API", version = "0.1.0"),security = {
//		@SecurityRequirement(name = "basicAuth") })
//@SecurityScheme(name = "jwtToken", type = SecuritySchemeType.HTTP, scheme = "bearer", bearerFormat = "JWT")
//@SecurityScheme(name = "basicAuth", type = SecuritySchemeType.HTTP, scheme = "basic")
@Configuration
public class OpenApiConfiguration {
}
