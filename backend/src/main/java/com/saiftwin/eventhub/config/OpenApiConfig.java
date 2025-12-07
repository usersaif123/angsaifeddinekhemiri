package com.saiftwin.eventhub.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI eventHubOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("EventHub API")
                        .description("Event Management System REST API Documentation")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Twin7 EventHub Team")
                                .email("contact@eventhub.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0.html")));
    }
}
