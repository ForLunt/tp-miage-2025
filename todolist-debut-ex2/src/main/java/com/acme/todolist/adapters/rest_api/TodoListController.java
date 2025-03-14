package com.acme.todolist.adapters.rest_api;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.acme.todolist.application.port.in.AddTodoItem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.acme.todolist.application.port.in.GetTodoItems;
import com.acme.todolist.domain.TodoItem;

/**
 * Le controlleur Spring MVC qui expose les endpoints REST
 * 
 * @author bflorat
 *
 */
@RestController
public class TodoListController {
	
	
	private GetTodoItems getTodoItemsQuery;
	private AddTodoItem addTodoItemQuery;
	
	@Inject
	public TodoListController(GetTodoItems getTodoItemsQuery, AddTodoItem addTodoItemQuery) {
		this.getTodoItemsQuery = getTodoItemsQuery;
		this.addTodoItemQuery =addTodoItemQuery;
	}
	
	@GetMapping("/todos")
	public List<TodoItem> getAllTodoItems() {
		return this.getTodoItemsQuery.getAllTodoItems();
	}
	
	
	// Endpoint de type POST vers "/todos"
	@PostMapping("/todos")
	public ResponseEntity<Void> ajouterItem(@RequestBody TodoItem item) {
		addTodoItemQuery.addTodoItem(item); // Exécute la logique mais ne retourne rien
		return ResponseEntity.status(201).build();
	}
	
	
}
