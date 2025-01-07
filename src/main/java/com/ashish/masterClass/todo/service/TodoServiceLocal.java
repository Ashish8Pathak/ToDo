package com.ashish.masterClass.todo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.ashish.masterClass.todo.beans.Todo;

@Service
public class TodoServiceLocal{

	private static List<Todo> todos = new ArrayList<>();
	private static int todoCount = 0;
	

	static {
		todos.add(new Todo(++todoCount,"Ashish","Springboot Local",LocalDate.now().plusMonths(1),false));
		todos.add(new Todo(++todoCount,"Ashish","Azure Developer Local",LocalDate.now().plusMonths(1),false));
		todos.add(new Todo(++todoCount,"Pathak","AWS Developer Local",LocalDate.now().plusMonths(1),false));
	}
	
	public List<Todo> findByUser(String user){
		Predicate<? super Todo> username = todo -> todo.getUser().equalsIgnoreCase(user);
		return todos.stream().filter(username).toList();
	}
	
	public void addTaskToList(String user, String details, LocalDate dueDate, boolean isComplete) {
		todos.add(new Todo(++todoCount,user,details,dueDate,isComplete));
	}
	
	public void deleteById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}
	
	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		return todos.stream().filter(predicate).findFirst().get();
	}
	
	public void updateTask(Todo todo) {
		deleteById(todo.getId());
		addTaskToList(todo.getUser(),todo.getTask(),todo.getDueDate(),todo.isComplete());
	}
}
