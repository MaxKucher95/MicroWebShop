package de.hska.iwi.vslab.rolecore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@SpringBootApplication
public class RolecoreApplication {

  private static final Logger log = LoggerFactory.getLogger(RolecoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RolecoreApplication.class, args);
  }
  
  @Bean
	public CommandLineRunner demo(RoleRepository repository) {
		return (args) -> {
			// save a few Roles
			repository.save(new Role("admin", 0));
			repository.save(new Role("user", 1));

			// fetch all Roles
			log.info("Roles found with findAll():");
			log.info("-------------------------------");
			for (Role role : repository.findAll()) {
				log.info(role.toString());
			}
			log.info("");

			// fetch an individual Role by ID
			Role role = repository.findById(1);
			log.info("Role found with findById(1):");
			log.info("--------------------------------");
			log.info(role.toString());
			log.info("");
		};
	}

}
