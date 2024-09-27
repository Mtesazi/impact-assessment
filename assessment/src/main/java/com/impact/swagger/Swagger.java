package com.impact.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class Swagger {
    @Bean
    public OpenAPI swaggerConfiguration(){
        Server server = new Server();
        server.setUrl("http://localhost:8080");
        server.setDescription("Development");

        Contact contact = new Contact();
        contact.setName("Bongani Gumede");
        contact.setEmail("Mtesazi@gmail.com");
        Info information = new Info()
                .title("Employee Management System")
                .contact(contact)
                .description("This API exposes endpoints to manage employees.");
        return new OpenAPI().info((Info) information).servers(List.of(server));
    }
}
