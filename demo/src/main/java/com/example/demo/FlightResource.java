package com.example.demo;


import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.Flight;

@CrossOrigin(origins="http://localhost:4200")
@RestController

public class FlightResource {
	
	@Autowired
	private FlightRepository todoJpaRepository;

	
	@GetMapping("/flights")
	

	public List<Flight> getAllTodos(){
		return todoJpaRepository.findAll();
		//return todoService.findAll();
	}

	@GetMapping("/flights/{id}")
	public Flight getTodo(@PathVariable long id){
		return todoJpaRepository.findById(id).get();
		//return todoService.findById(id);
	}

	//DELETE /users/{username}/todos/{id}
	@DeleteMapping("/flights/{id}")
	public ResponseEntity<Void> deleteTodo(
			 @PathVariable long id){
		
		//Todo todo = todoService.deleteById(id);
		todoJpaRepository.deleteById(id);
		
		return ResponseEntity.noContent().build();
		//return ResponseEntity.notFound().build();
	}
	

	//Edit/Update a Todo
	//PUT /users/{user_name}/todos/{todo_id}
	@PutMapping("/flights/{id}")
	public ResponseEntity<Flight> updateTodo(
			@PathVariable long id, @RequestBody Flight todo){
		
		//Todo todoUpdated = todoService.save(todo);
		Flight todoUpdated = todoJpaRepository.save(todo);
		
		return new ResponseEntity<Flight>(todo, HttpStatus.OK);
	}
	
	@PostMapping("/flights")
	public ResponseEntity<Void> createTodo(
	 @RequestBody Flight todo){
		
		//Todo createdTodo = todoService.save(todo);
		Flight createdTodo = todoJpaRepository.save(todo);
		
		//Location
		//Get current resource url
		///{id}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
		
}