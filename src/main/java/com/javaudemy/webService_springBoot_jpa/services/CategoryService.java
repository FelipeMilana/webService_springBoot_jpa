package com.javaudemy.webService_springBoot_jpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaudemy.webService_springBoot_jpa.entities.Category;
import com.javaudemy.webService_springBoot_jpa.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository userRepository;
	
	public List<Category> findAll() {
		return userRepository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = userRepository.findById(id);
		return obj.get();
	}
}
