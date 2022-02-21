package com.braincustom.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.braincustom.domain.Todo;
import com.braincustom.services.TodoService;

/* "*"a api no endpoint "/todos", recebe requisições de múltiplas fontes. 
 * Uma vez que se está se criando um frontend roda na porta 4200*/
@CrossOrigin("*")
@RestController
@RequestMapping(value="/todos")
public class TodoResource {

	@Autowired
	private TodoService service;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Todo> findById(@PathVariable Integer id){
		Todo obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value="/open")
	public ResponseEntity<List<Todo>> listOpen(){
		List<Todo> list = service.findAllOpen();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/close")
	public ResponseEntity<List<Todo>> listClose(){
		List<Todo> list = service.findAllClose();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping
	public ResponseEntity<List<Todo>> listAll(){
		List<Todo> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	/*
	 * implementando um endpoint que irá receber uma requisição http
	 * do tipo Post pra criação de um novo Todo*/ 
	@PostMapping
	public ResponseEntity<Todo> created(@RequestBody Todo obj){
		obj = service.created(obj);
		/*
		 * boas práticas: retornar p o usuário a URI de acesso 
		 * ao novo objeto*/
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	//apagando um Todo
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	/*atualizando informações: precisar do id e do
	 * Todo com as info atualizadas no corpo da requisição(@RequestBody)*/
	@PutMapping(value="/{id}")
	public ResponseEntity<Todo> update(@PathVariable Integer id, @RequestBody Todo obj){
		Todo newObj = service.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}
}
