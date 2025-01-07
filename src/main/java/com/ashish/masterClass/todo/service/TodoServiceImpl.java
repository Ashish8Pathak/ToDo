package com.ashish.masterClass.todo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.ashish.masterClass.todo.beans.Todo;
import com.ashish.masterClass.todo.repository.TodoRepository;

@Service
@Primary
public class TodoServiceImpl implements TodoService {

	private TodoRepository todoRepository;
	
	
	public TodoServiceImpl(TodoRepository todoRepository) {
		super();
		this.todoRepository = todoRepository;
	}
	
	public List<Todo> findByUser(String user){
		return todoRepository.findByUser(user.toUpperCase());
	}
	
	public void addTaskToList(Integer id,String user, String details, LocalDate dueDate, boolean isComplete) {
		  todoRepository.save(new Todo(id,user,details,dueDate,isComplete));
	}
	
	public void deleteById(int id) {
		todoRepository.deleteById(id);
	}
	
	public Todo findById(int id) {
		return todoRepository.findById(id).get();
	}
	
	public void updateTask(Todo todo) {
		deleteById(todo.getId());
		todoRepository.save(new Todo(todo.getId(),todo.getUser(),todo.getTask(),todo.getDueDate(),todo.isComplete()));
	}	
}
