package com.braincustom;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.braincustom.domain.Todo;
import com.braincustom.repositories.TodoRepository;

@SpringBootApplication
public class SpringAngularApplication implements CommandLineRunner {

	@Autowired
	private TodoRepository todoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringAngularApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		//instância do Todo sempre que a aplicação iniciar
		Todo t1 = new Todo(null, "Estudar", "Estudar Spring Boot 2 e Angular 11", LocalDateTime.parse("26/03/2022 10:46", formatter), false);
		
		todoRepository.saveAll(Arrays.asList(t1));
	}
}
