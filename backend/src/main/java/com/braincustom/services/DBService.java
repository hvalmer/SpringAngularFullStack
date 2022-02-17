package com.braincustom.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.braincustom.domain.Todo;
import com.braincustom.repositories.TodoRepository;

@Service
public class DBService {

	@Autowired
	private TodoRepository todoRepository;

	public void instanciaBaseDeDados() {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		// instância do Todo sempre que a aplicação iniciar
		Todo t1 = new Todo(null, "Estudar", "Estudar Spring Boot 2 e Angular 11",
				LocalDateTime.parse("26/03/2022 10:46", formatter), false);
		Todo t2 = new Todo(null, "Ler", "Ler livro de desenvolvimento pessoal",
				LocalDateTime.parse("24/04/2022 08:50", formatter), true);
		Todo t3 = new Todo(null, "Exercícios", "Praticar atividade física",
				LocalDateTime.parse("26/03/2022 10:46", formatter), false);
		Todo t4 = new Todo(null, "Meditar", "Praticar meditação guiada",
				LocalDateTime.parse("26/03/2022 10:46", formatter), false);

		todoRepository.saveAll(Arrays.asList(t1, t2, t3, t4));
	}
}
