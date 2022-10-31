package webapp.geektext.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import webapp.geektext.entities.Book;
import webapp.geektext.repos.AuthorRepo;
import webapp.geektext.repos.BookRepo;

@Service
public class BookService {

	@Autowired BookRepo bookRepo;
	@Autowired AuthorRepo authorRepo;
	@Autowired AuthorService authorService;
	public BookService() {
		
	}
	
	public ResponseEntity<List<Book>> getBooks() {
		List<Book> booksToReturn =   bookRepo.findAll();
		
		if(booksToReturn.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<List<Book>>(booksToReturn, HttpStatus.OK);
		}
	}
	
	public ResponseEntity<Optional <Book>> getBookByISBN(long id) {
		if(bookRepo.findById(id).isPresent()){
			Optional<Book> bookToReturnBook = bookRepo.findById(id);
			return new ResponseEntity<Optional<Book>>(bookToReturnBook, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<List<Book>> getBooksByAuthorName(String authorFullName) {
		Long authorId = authorService.getAuthorIdByName(authorFullName);
		
		List<Book> bookListToReturn = new ArrayList<Book>(); // Book List to Return
		List<Book> booksToSearch = bookRepo.findAll();
		
		for (Book book : booksToSearch) {
			if(book.getBookAuthorId().equals(authorId)) {
				bookListToReturn.add(book);
			}
		}
		if(bookListToReturn.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<List<Book>>(bookListToReturn, HttpStatus.OK);
		}
	}
	
	public ResponseEntity<String> addBook(Book book) {
		List<Book> listOfBooks = bookRepo.findAll();
		
		for(Book currentBook : listOfBooks) {
			if(book.getBookISBN() == currentBook.getBookISBN()) {
				return new ResponseEntity<String>("FAILED: ISBN already exists", HttpStatus.BAD_REQUEST);
			}
		}
		
		bookRepo.save(book);
		
		return new ResponseEntity<String>("SUCCESS: Book Created ", HttpStatus.CREATED);
	}
	
}
