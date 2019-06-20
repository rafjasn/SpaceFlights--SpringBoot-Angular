package com.example.demo;


import java.net.URI;
import java.util.List;

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

public class TouristResource {
	
	@Autowired
	private TouristRepository touristRepository;

	
	@GetMapping("/tourists")
	public List<Tourist> getAllTodos(){
		return touristRepository.findAll();
		//return todoService.findAll();
	}

	@GetMapping("/tourists/{id}")
	public Tourist getTodo( @PathVariable long id){
		return touristRepository.findById(id).get();
		//return todoService.findById(id);
	}

	//DELETE /users/{username}/todos/{id}
	@DeleteMapping("/tourists/{id}")
	public ResponseEntity<Void> deleteTodo(
		 @PathVariable long id){
		
		//Todo todo = todoService.deleteById(id);
		touristRepository.deleteById(id);
		
		return ResponseEntity.noContent().build();
		//return ResponseEntity.notFound().build();
	}


	//Edit/Update a Todo
	//PUT /users/{user_name}/todos/{todo_id}
	@PutMapping("/tourists/{id}")
	public ResponseEntity<Tourist> updateTodo(
			@PathVariable long id, @RequestBody Tourist todo){
		
		//Todo todoUpdated = todoService.save(todo);
		Tourist todoUpdated = touristRepository.save(todo);
		
		return new ResponseEntity<Tourist>(todo, HttpStatus.OK);
	}
	
	@PostMapping("/tourists")
	public ResponseEntity<Void> createTodo(
			 @RequestBody Tourist todo){
		
		//Todo createdTodo = todoService.save(todo);
		Tourist createdTodo = touristRepository.save(todo);
		
		//Location
		//Get current resource url
		///{id}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
		
}