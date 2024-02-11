package com.example.graphqlstudy;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class GraphqlStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlStudyApplication.class, args);
	}

	@Bean
	ApplicationRunner  applicationRunner(AuthorRepository authorRepository, BookRepository bookRepository){
		return args -> {
			Author Murat = authorRepository.save(new Author("MURAT"));
			Author Tarum = authorRepository.save(new Author("TARUM"));
			bookRepository.saveAll(List.of(
					new Book("BRUH","BRUH",Murat),
					new Book("HRUB","HRUB",Tarum)
			));
		};
	}
}
