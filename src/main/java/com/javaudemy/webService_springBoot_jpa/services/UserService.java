package com.javaudemy.webService_springBoot_jpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaudemy.webService_springBoot_jpa.entities.User;
import com.javaudemy.webService_springBoot_jpa.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.get();
	}
	
	/*Save method, already return the object that will be 
	 * saved on DataBase
	 */
	public User insert(User obj) {
		return userRepository.save(obj);
	}
	
	public void delete(Long id) {
		userRepository.deleteById(id);
	}
	
	/*We use an id and an object as an argument, because 
	 * with id, we identify who are this user, and with the
	 * object, we have the new data about this user. The getOne just
	 * prepare not recover the user from database.
	 */
	public User update(Long id, User obj) {
		User entity = userRepository.getOne(id);
		updateData(entity, obj);
		return userRepository.save(entity);
	}
	
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
