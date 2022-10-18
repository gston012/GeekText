package webapp.geektext.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import webapp.geektext.entities.Shopping_cart;
import webapp.geektext.services.Shopping_cartService;
import java.util.List;

@RestController
public class Shopping_cartController {

    @Autowired
    Shopping_cartService shopping_cartService ;

    @GetMapping("/shoppingcart")
    public ResponseEntity<List<Shopping_cart>> getShopping_cart() {
        return shopping_cartService.getShopping_cart();
    }



}
