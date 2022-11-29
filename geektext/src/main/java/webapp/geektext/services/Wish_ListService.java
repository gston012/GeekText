package webapp.geektext.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import webapp.geektext.entities.Wish_List;
import webapp.geektext.repos.Wish_ListRepo;

import java.util.List;
import java.util.Optional;

@Service
public class Wish_ListService {

	private final Wish_ListRepo wishlistRepo;
	
    @Autowired 

    public Wish_ListService(Wish_ListRepo wishlistRepo){
    	this.wishlistRepo = wishlistRepo;

    }

    public ResponseEntity<List<Wish_List>> getWish_List() {
        List<Wish_List> Wish_ListToReturn = wishlistRepo.findAll();

        if(Wish_ListToReturn .isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<List<Wish_List>>(Wish_ListToReturn , HttpStatus.OK);
        }
    }

	public Optional<Wish_List> findByUser(String user) {
		if(!wishlistRepo.existsById(user)) {
			throw new ResponseStatusException (HttpStatus.NOT_FOUND, "User " + user + " does not has not created a wishlist");
		}
		// TODO Auto-generated method stub
		return wishlistRepo.findById(user);
	}
}
