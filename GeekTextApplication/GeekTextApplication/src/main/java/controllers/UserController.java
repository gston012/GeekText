package controllers;
import entities.User;

import repo.UserRepo;
import services.UserService;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	    public ResponseEntity<User> findUserById(@PathVariable("user_email") String id) {
			return UserService.findUserById(id);
		}
	 
	    @PostMapping
	    public ResponseEntity<String> createUser(@RequestBody User user) {
			return UserService.createUser(user);
		}
	    
	    @RequestMapping(value="/user/{user_email}", method=RequestMethod.PUT)
	    public User readUsers(@PathVariable(value = "user_email") String id, @RequestBody User userDetails) {
	        return UserService.updateUser(id, userDetails);
	    }
}
