package webapp.geektext.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import webapp.geektext.entities.Wish_List;
import webapp.geektext.repos.Wish_ListRepo;
import webapp.geektext.entities.Book;
import webapp.geektext.repos.BookRepo;

import java.util.List;
import java.util.Optional;

@Service
public class Wish_ListService {

	
    @Autowired Wish_ListRepo wishlistRepo;
 @Autowired BookRepo bookRepo;

    public Wish_ListService(){

    }
//returns all wishlist within database
    public ResponseEntity<List<Wish_List>> getWish_List() {
        List<Wish_List> Wish_ListToReturn = wishlistRepo.findAll();

        if(Wish_ListToReturn .isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<List<Wish_List>>(Wish_ListToReturn , HttpStatus.OK);
        }
    }

	public ResponseEntity<String> addBook(Book book) {
		List<Book> listOfBooks = bookRepo.findAll();
		
		for(Book currentBook : listOfBooks) {
			if(book.getBookISBN() == currentBook.getBookISBN()) {
				return new ResponseEntity<String>("FAILED: ISBN already located in Wishlist", HttpStatus.BAD_REQUEST);
			}
		}
		
		return bookRepo.save(book);
		
	}
}
