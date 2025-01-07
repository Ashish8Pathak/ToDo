package com.ashish.masterClass.todo.controller;

import java.time.LocalDate;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ashish.masterClass.todo.beans.Todo;
import com.ashish.masterClass.todo.service.TodoServiceImpl;
import com.ashish.masterClass.todo.service.TodoService;
import com.ashish.masterClass.todo.service.TodoServiceImpl;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoController {

	private TodoService todoService;

	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}
	
	@RequestMapping(value="getUserTask",method=RequestMethod.GET)
	public String getUserTask(ModelMap model) {
		model.put("todos",todoService.findByUser(getLoggedInUser()));
		return "TodoList";
	}
	
	@RequestMapping(value="add-todo",method=RequestMethod.GET)
	public String addTask(ModelMap model) {
		String user = getLoggedInUser();
		Todo todo = new Todo();
		model.put("todo", todo);
		return "addTodo";
	}
	
	@RequestMapping(value="add-todo",method=RequestMethod.POST)
	public String addTask(ModelMap model, @Valid Todo todo, BindingResult result) {

		if (result.hasErrors()) {
			model.put("todo",todo);
			return "addTodo";
		}
		
		todoService.addTaskToList(todo.getId(),getLoggedInUser(),todo.getTask(), todo.getDueDate(), todo.isComplete());
		//model.put("todos", todoService.findByUser(getLoggedInUser()));
		return "redirect:getUserTask";
	}
	
	@RequestMapping("delete-task")
	public String deleteTask(@RequestParam int id){
		todoService.deleteById(id);
		return "redirect:getUserTask";
	}
	
	@RequestMapping(value="update-task",method=RequestMethod.GET)
	public String gotoUpdatePage(@RequestParam int id,ModelMap model){
		Todo todo = todoService.findById(id);
		model.put("todo", todo);
		return "addTodo";
	}
	
	@RequestMapping(value="update-task",method=RequestMethod.POST)
	public String UpdateTask(@Valid Todo todo, BindingResult result,ModelMap model){
		
		if (result.hasErrors()) {
			model.put("todo",todo);
			return "addTodo";
		}
		
		todo.setUser(getLoggedInUser());
		todoService.updateTask(todo);
		model.put("todos", todoService.findByUser(getLoggedInUser()));
		return "redirect:getUserTask";
	}
	
	
	private String getLoggedInUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName().toUpperCase();
	}
	
	
}
