package ru.denmehta.iikoService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"ru.denmehta.iikoService"})
@EntityScan("ru.denmehta.iikoService")
@EnableJpaRepositories("ru.denmehta.iikoService.repository")
public class IikoServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(IikoServiceApplication.class);
    }
}