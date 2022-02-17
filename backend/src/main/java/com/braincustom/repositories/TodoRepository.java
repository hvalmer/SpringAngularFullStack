package com.braincustom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.braincustom.domain.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

}
