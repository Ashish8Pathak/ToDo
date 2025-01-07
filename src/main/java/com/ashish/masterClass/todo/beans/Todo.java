package com.ashish.masterClass.todo.beans;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity(name="TASK")
public class Todo {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(name="username")
	private String user;
	
	@Size(min=4,message="Task should have atleast 10 letters")
	private String task;
	private LocalDate dueDate;
	private boolean complete;
	
	public Todo() {
		super();
	}
	
	public Todo(String user, @Size(min = 4, message = "Task should have atleast 10 letters") String task,
			LocalDate dueDate, boolean complete) {
		super();
		this.user = user;
		this.task = task;
		this.dueDate = dueDate;
		this.complete = complete;
	}

	
	public Todo(Integer id, String user, @Size(min = 4, message = "Task should have atleast 10 letters") String task,
			LocalDate dueDate, boolean complete) {
		super();
		this.id = id;
		this.user = user;
		this.task = task;
		this.dueDate = dueDate;
		this.complete = complete;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", user=" + user + ", task=" + task + ", dueDate=" + dueDate + ", complete="
				+ complete + "]";
	}
	
	
	
}

