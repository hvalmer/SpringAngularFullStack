package com.braincustom.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.braincustom.domain.Todo;
import com.braincustom.repositories.TodoRepository;
import com.braincustom.services.exceptions.ObjectNotFoundException;

@Service
public class TodoService {

	@Autowired
	private TodoRepository repository;
	
	public Todo findById(Integer id) {
		Optional<Todo> obj = repository.findById(id);
		//agora tratando o objeto Todo não encontrado
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado id: " + 
		id + ", Tipo: " + Todo.class.getName()));
	}

	public List<Todo> findAllOpen() {
		List<Todo> list = repository.findAllOpen();
		return list;
	}

	public List<Todo> findAllClose() {
		List<Todo> list = repository.findAllClose();
		return list;
	}

	public List<Todo> findAll() {
		List<Todo> list = repository.findAll();
		return list;
	}

	public Todo created(Todo obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public void delete(Integer id) {
		repository.deleteById(id);		
	}
	
	
}
