package com.javaudemy.webService_springBoot_jpa.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.javaudemy.webService_springBoot_jpa.entities.User;
import com.javaudemy.webService_springBoot_jpa.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
 
	@Autowired
	private UserService userService;
	
	/*EndPoints with @Get annotations, are used to 
	 * return or recover something from database
	 */
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = userService.findAll();	
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = userService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	/*EndPoints with @Post annotation, are used to insert
	 * something on Database
	 */
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){
		obj = userService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	/*EndPoints with @Delete annotation, are used to delete
	 * something on Database
	 */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	/*EndPoints with @Put annotation, are used to update
	 * something on Database
	 */
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj) {
		obj = userService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
