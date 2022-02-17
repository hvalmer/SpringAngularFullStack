package com.braincustom.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.braincustom.domain.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

	//método que vai listar todos os Todos na base de dados que estão em aberto 
	@Query("SELECT obj FROM Todo obj WHERE obj.finalizado = false ORDER BY obj.dataParaFinalizar")
	List<Todo> findAllOpen();

	//método que vai listar todos os Todos na base de dados que estão fechados
		@Query("SELECT obj FROM Todo obj WHERE obj.finalizado = true ORDER BY obj.dataParaFinalizar")
	List<Todo> findAllClose();

}
