package services;

import repo.UserRepo;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import entities.User;

@Service
public class UserService {

	@Autowired
	static
	 UserRepo UserRepo;
	
	public UserService(){
	
	}
	
	
	  public static ResponseEntity<User> findUserById(@PathVariable(value = "user_email") String id) {
	       
	    	Optional<User> User = UserRepo.findById(id);
	    	 
	        if(User.isPresent()) {
	            return ResponseEntity.ok().body(User.get());
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    	
	    }
	
	  
	  public static ResponseEntity<String> addUser(User user){
		  
		  UserRepo.save(user);
		  return new ResponseEntity<String>("SUCCESS: User Created ", HttpStatus.CREATED);
	  }
}
