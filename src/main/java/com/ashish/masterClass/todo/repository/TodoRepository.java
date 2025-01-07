package com.ashish.masterClass.todo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ashish.masterClass.todo.beans.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

	public List<Todo> findByUser(String user);

}
