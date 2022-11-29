package webapp.geektext.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webapp.geektext.entities.Wish_List;
import webapp.geektext.services.Wish_ListService;
import webapp.geektext.services.BookService;
import webapp.geektext.entities.Book;
import java.util.List;
import java.util.Optional;

@RestController

public class Wish_ListController {

    @Autowired Wish_ListService wishlistService;
    @Autowired BookService bookService;

      @GetMapping("/{wishlist:(?!)wishlist}")
    public ResponseEntity<List<Wish_List>> getWish_List() {
        return wishlistService.getWish_List();

    }
    
    
    @PostMapping("/{wishlist: (?!)wishlist}/{addbook: (?!)addbook}")
    public ResponseEntity<String> addBook(@RequestBody Book book){
        return bookService.addbook(book);
    }

}
