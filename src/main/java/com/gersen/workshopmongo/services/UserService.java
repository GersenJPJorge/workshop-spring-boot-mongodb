package com.gersen.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gersen.workshopmongo.domain.User;
import com.gersen.workshopmongo.dto.UserDto;
import com.gersen.workshopmongo.repository.UserRepository;
import com.gersen.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}
	  
/*		public User findById(String id) {
			User user = repo.findOne(id);
			if (user == null ) {
				throw new ObjectNotFoundException("Object not found");
				
			}
			return user;
		}
*/		
		  
		public User findById(String id) {
			Optional<User> obj = repo.findById(id);
			return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto " + id + " não encontrado "));
		}
		
		public User insert(User obj) {
			return repo.insert(obj);
		}	
			
		public User fromDto(UserDto objDto) {
			return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
		}	
			
}
