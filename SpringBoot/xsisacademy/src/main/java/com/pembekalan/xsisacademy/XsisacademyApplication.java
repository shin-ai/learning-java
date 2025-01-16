package com.pembekalan.xsisacademy;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.javafaker.Faker;
import com.pembekalan.xsisacademy.entity.Author;
import com.pembekalan.xsisacademy.entity.Book;
import com.pembekalan.xsisacademy.entity.Category;
import com.pembekalan.xsisacademy.entity.Publisher;
import com.pembekalan.xsisacademy.entity.User;
import com.pembekalan.xsisacademy.repository.AuthorRepository;
import com.pembekalan.xsisacademy.repository.BookRepository;
import com.pembekalan.xsisacademy.repository.CategoryRepository;
import com.pembekalan.xsisacademy.repository.PublisherRepository;
import com.pembekalan.xsisacademy.repository.UserRepository;

@SpringBootApplication
public class XsisacademyApplication {

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PublisherRepository publisherRepository;
	
	@Autowired
	AuthorRepository authorRepository;

	@Autowired
	BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(XsisacademyApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
            Category thriller = new Category("Thriller");
			Category novel = new Category("Noverl");
			Category horror = new Category("Horror");

			categoryRepository.save(thriller);
			categoryRepository.save(novel);
			categoryRepository.save(horror);

			Faker faker = new Faker(Locale.forLanguageTag("id-ID"));

			for (int i = 0; i < 10 ; i++) {
				User userSeed = new User(faker.name().fullName(), faker.phoneNumber().phoneNumber(), faker.address().fullAddress());
				userRepository.save(userSeed);
			}

			for (int i = 0; i < 10 ; i++) {
				Publisher publisherSeed = new Publisher(faker.book().publisher(), faker.address().fullAddress());
				publisherRepository.save(publisherSeed);
			}
			
			for (int i = 0; i < 10 ; i++) {
				Author authorSeed = new Author(faker.name().fullName(), faker.random().nextInt(1, 10));
				authorRepository.save(authorSeed);
			}
			
			for (int i = 0; i < 10 ; i++) {
				Category categorySeed = categoryRepository.findById(faker.random().nextInt(1, 3)).orElse(null);
				Publisher publisherSeed = publisherRepository.findById(faker.random().nextInt(1, 10)).orElse(null);;
				Author authorSeed = authorRepository.findById(faker.random().nextInt(1, 10)).orElse(null);;
				
				Book bookSeed = new Book(
						authorSeed,
						categorySeed,
						publisherSeed,
					    faker.book().title(),
                        faker.weather().description(),
                        faker.number().numberBetween(100, 500),
                        faker.number().numberBetween(2010, 2025)
				);
				bookRepository.save(bookSeed);
			}
        };
	};
}
