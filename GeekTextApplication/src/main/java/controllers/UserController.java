package controllers;
import entities.User;
import repo.UserRepo;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	
	 @Autowired
	    private UserRepo UserRepo;
	        
	    @GetMapping
	    public List<User> findAllUsers() {
	    	
	    	return UserRepo.findAll();
	        
	    }
	 
	    @GetMapping("/{user_email}")
	    public ResponseEntity<User> findUserById(@PathVariable(value = "user_email") String user_email) {
	       
	    	Optional<User> User = UserRepo.findById(user_email);
	    	 
	        if(User.isPresent()) {
	            return ResponseEntity.ok().body(User.get());
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    	
	    }
	 
	    @PostMapping
	    public User saveUser(@Validated @RequestBody User user) {
	    	
	    	return UserRepo.save(user);
	        
	    }
}
