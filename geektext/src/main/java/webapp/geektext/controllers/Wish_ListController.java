package webapp.geektext.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import webapp.geektext.entities.Wish_List;
import webapp.geektext.services.Wish_ListService;
import java.util.List;

@RestController
public class Wish_ListController {

    @Autowired
    Wish_ListService wishlistService ;

    @GetMapping("/wishlist")
    public ResponseEntity<List<Wish_List>> getWish_List() {
        return wishlistService.getWish_List();
    }



}
