package webapp.geektext.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import webapp.geektext.entities.Author;
import webapp.geektext.entities.Book;
import webapp.geektext.services.AuthorService;
import webapp.geektext.services.BookService;

@RestController
public class AdminController {

	@Autowired AuthorService authorService;
	@Autowired BookService bookService;
	
	@GetMapping("/{admin:(?i)admin}")
	public String getAdmin() {
		return "Welcome to the admin page. You can create a book using /addbook or an author using /addauthor";
	}
	
	@PostMapping("/{admin:(?i)admin}/{addauthor:(?i)addauthor}")
	public ResponseEntity<String> addAuthor(@RequestBody Author author) {
		return authorService.addAuthor(author);
	}
	
	@PostMapping("/{admin:(?i)admin}/{addBook:(?i)addBook}")
	public ResponseEntity<String> addBook(@RequestBody Book book) {
		return bookService.addBook(book);
		
		
	}
}
