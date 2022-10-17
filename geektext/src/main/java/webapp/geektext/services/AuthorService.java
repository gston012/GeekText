package webapp.geektext.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import webapp.geektext.entities.Author;
import webapp.geektext.repos.AuthorRepo;

@Service
public class AuthorService {
	
	@Autowired AuthorRepo authorRepo;
	public AuthorService() {
		
	}
	
	public ResponseEntity<List<Author>> getAuthors() {
		List<Author> authorsToReturn = authorRepo.findAll();
		if(authorsToReturn.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<List<Author>>(authorsToReturn, HttpStatus.OK);
		}
	}
	
//	public Optional<Author> getAuthorById(long id) {
//		return authorRepo.findById(id);
//	}
	
	public long getAuthorIdByName(String fullName) {
		List<Author> allAuthors = authorRepo.findAll();
		for(Author currentAuthor : allAuthors) {
			if(fullName.equalsIgnoreCase(currentAuthor.getAuthorFirstName() + " " + currentAuthor.getAuthorLastName())){
				//System.out.println("Found Author ID: " + currentAuthor.getAuthorId());   //use for debug
				return currentAuthor.getAuthorId();
			}
		}
		//System.out.println("AuthorID not Found"); //use for debug
		return -1;
	}
}
