package com.deepak.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;

@SpringBootApplication
public class SchoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolApplication.class, args);
		System.out.println("Application Started!");
	}

	@Bean
	public Jackson2RepositoryPopulatorFactoryBean getRespositoryPopulator() {
		Jackson2RepositoryPopulatorFactoryBean factory = new Jackson2RepositoryPopulatorFactoryBean();
		factory.setResources(new Resource[]{new ClassPathResource("classes.json"),
											new ClassPathResource("exams.json"),
											new ClassPathResource("subjects.json")});
		return factory;
	}
}
