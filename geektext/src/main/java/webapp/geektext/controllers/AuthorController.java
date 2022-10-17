package webapp.geektext.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import webapp.geektext.entities.Author;
import webapp.geektext.services.AuthorService;

@RestController
public class AuthorController {

	@Autowired
	AuthorService authorService;
	
	@GetMapping("/{authors:(?i)authors}")
	public ResponseEntity<List<Author>> getAuthors() {
		return authorService.getAuthors();
	}
	
	
}
