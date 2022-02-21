package com.braincustom.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.braincustom.domain.Todo;
import com.braincustom.repositories.TodoRepository;

@Service
public class DBService {

	@Autowired
	private TodoRepository todoRepository;

	public void instanciaBaseDeDados() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		// instância do Todo sempre que a aplicação iniciar
		Todo t1 = new Todo(null, "Estudar", "Estudar Spring Boot 2 e Angular 11",
				sdf.parse("26/03/2022"), false);
		Todo t2 = new Todo(null, "Ler", "Ler livro de desenvolvimento pessoal",
				sdf.parse("24/04/2022"), true);
		Todo t3 = new Todo(null, "Exercícios", "Praticar atividade física",
				sdf.parse("26/03/2022"), false);
		Todo t4 = new Todo(null, "Meditar", "Praticar meditação guiada",
				sdf.parse("26/03/2022"), true);

		todoRepository.saveAll(Arrays.asList(t1, t2, t3, t4));
	}
}
