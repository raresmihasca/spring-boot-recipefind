package com.RecipeFind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@ComponentScan({"com.RecipeFind.services", "com.RecipeFind.controllers", "com.RecipeFind.validation", "com.RecipeFind.repositories", "com.RecipeFind.config"})
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableJpaRepositories("com.RecipeFind.repositories")
@EntityScan("com.RecipeFind.models")
public class RecipeFindApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeFindApplication.class, args);
	}

}
