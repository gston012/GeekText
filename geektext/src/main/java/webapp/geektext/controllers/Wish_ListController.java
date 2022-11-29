package webapp.geektext.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webapp.geektext.entities.Wish_List;
import webapp.geektext.services.Wish_ListService;
import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/wishlist")
public class Wish_ListController {

    private final Wish_ListService wishlistService;

    @Autowired
    public Wish_ListController(Wish_ListService wishlistService) {
        this.wishlistService = wishlistService;
    }


      @GetMapping("/{user}")
    public Optional<Wish_List> findByUser(@PathVariable String user) {
        return wishlistService.findByUser(user);
    }



}
