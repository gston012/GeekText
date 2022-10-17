package webapp.geektext.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import webapp.geektext.entities.Book;
import webapp.geektext.services.BookService;

@RestController
public class BookController {

	@Autowired
	BookService bookService;
	
	@GetMapping("/{books:(?i)books}")
	public ResponseEntity<List<Book>> getBooks() {
		return bookService.getBooks();
	}
	
	@GetMapping("{books:(?i)books}/{byisbn:(?i)byisbn}/{bookISBN}")
	public ResponseEntity<Optional<Book>> getBookByISBN(@PathVariable("bookISBN") Long id) {
		return bookService.getBookByISBN(id); 
	}
		
	@GetMapping("{books:(?i)books}/{byauthor:(?i)byauthor}/{authorFullName}")
	public ResponseEntity<List<Book>> getBooksByAuthor(@PathVariable("authorFullName") String authorFullName) {
		return bookService.getBooksByAuthorName(authorFullName);
	}
}
