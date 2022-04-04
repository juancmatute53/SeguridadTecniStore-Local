package com.example.seguridad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication

@RestController
public class SeguridadApplication {

    @GetMapping("/iniciar")
    public String login(){
        return "authenticated successfully" ;
    }

    @GetMapping("/getUsers")
    public List<User> getUsers(){
        return Stream.of(new User( 108,"TecniStore","tecnistore2022@gmail.com","0999041505")).
                collect(Collectors.toList());
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SeguridadApplication.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "8090"));
        app.run(args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("/**").allowedMethods("*").allowedOrigins("*");
            }
        };
    }

}
