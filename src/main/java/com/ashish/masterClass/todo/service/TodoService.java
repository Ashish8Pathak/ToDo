package com.ashish.masterClass.todo.service;

import java.time.LocalDate;
import java.util.List;

import com.ashish.masterClass.todo.beans.Todo;

public interface TodoService {
	
	public List<Todo> findByUser(String user);
	
	public void addTaskToList(Integer id,String user, String details, LocalDate dueDate, boolean isComplete);
	
	public void deleteById(int id);
	
	public Todo findById(int id);
	
	public void updateTask(Todo todo);
	
}
