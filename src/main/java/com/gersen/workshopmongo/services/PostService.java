package com.gersen.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gersen.workshopmongo.domain.Post;
import com.gersen.workshopmongo.repository.PostRepository;
import com.gersen.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	  
/*		public User findById(String id) {
			User user = repo.findOne(id);
			if (user == null ) {
				throw new ObjectNotFoundException("Object not found");
				
			}
			return user;
		}	
*/		
		  
		public Post findById(String id) {
			Optional<Post> obj = repo.findById(id);
			return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto " + id + " não encontrado "));
		}	
		
		public List<Post> findByTitle(String text) {
			return repo.findByTitleContainingIgnoreCase	(text);
		}
		
	}
