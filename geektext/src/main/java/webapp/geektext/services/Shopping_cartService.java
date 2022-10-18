package webapp.geektext.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import webapp.geektext.entities.Shopping_cart;
import webapp.geektext.repos.Shopping_cartRepo;

import java.util.List;

@Service
public class Shopping_cartService {

    @Autowired Shopping_cartRepo shoppingCartRepo;

    public Shopping_cartService(){

    }

    public ResponseEntity<List<Shopping_cart>> getShopping_cart() {
        List<Shopping_cart> Shopping_cartToReturn = shoppingCartRepo.findAll();

        if(Shopping_cartToReturn.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<List<Shopping_cart>>(Shopping_cartToReturn, HttpStatus.OK);
        }
    }
}
