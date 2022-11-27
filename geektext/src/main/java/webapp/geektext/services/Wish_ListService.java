package webapp.geektext.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import webapp.geektext.entities.Wish_List;
import webapp.geektext.repos.Wish_ListRepo;

import java.util.List;

@Service
public class Wish_ListService {

    @Autowired Wish_ListRepo wishlistRepo;

    public Wish_ListService(){

    }

    public ResponseEntity<List<Wish_List>> getWish_List() {
        List<Wish_List> Wish_ListToReturn = wishlistRepo.findAll();


        if(Wish_ListToReturn.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<List<Wish_List>>(Wish_ListToReturn, HttpStatus.OK);
        }
    }
}