package webapp.geektext.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import webapp.geektext.entities.Author;
import webapp.geektext.repos.AuthorRepo;
import webapp.geektext.services.AuthorService;

@RestController
public class BookController {

	
	@GetMapping("/books")
	public String getBooks() {
		return "This will return books";
	}
	
	
}
