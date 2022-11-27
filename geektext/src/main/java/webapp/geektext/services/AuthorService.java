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
	
	
	// Returns a list of all Authors. If no Authors exist, returns NO_CONTENT
	public ResponseEntity<List<Author>> getAuthors() {
		List<Author> authorsToReturn = authorRepo.findAll();
		if(authorsToReturn.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<List<Author>>(authorsToReturn, HttpStatus.OK);
		}
	}

	
	// Returns authorID from Authors Full Name. If no author found by name returns -1.
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
	
	
	// Adds author to Database. Returns error message for failures. 
	public ResponseEntity<String> addAuthor(Author author) {
		if(requiredFieldIsNull(author)) {
			return new ResponseEntity<String>("FAILED: Required field is NULL", HttpStatus.BAD_REQUEST);
		} else if(authorExists(author)) {
			return new ResponseEntity<String>("FAILED: Author already exists", HttpStatus.BAD_REQUEST);
		}
		
		authorRepo.save(author);
		return new ResponseEntity<String>("SUCCESS: Author created as AuthorID: " + author.getAuthorId(), HttpStatus.CREATED);
	}
	
	
	// Returns true if author exists in database, otherwise false
	public boolean authorExists(Author author) {
		List<Author> authorListToSearch = authorRepo.findAll();
		for (Author currentAuthor : authorListToSearch) {
			if(currentAuthor.getAuthorFirstName().equals(author.getAuthorFirstName()) && 
					currentAuthor.getAuthorLastName().equals(currentAuthor.getAuthorLastName()) &&
					currentAuthor.getAuthorPublisher().equals(currentAuthor.getAuthorPublisher())) {
				return true;
			}
		}
		return false;
	}
	
	
	// Returns true if a required author field is Null, else false
	public boolean requiredFieldIsNull(Author author) {
		if(author.getAuthorFirstName() == null ||
				author.getAuthorLastName() == null ||
				author.getAuthorBiography() == null ||
				author.getAuthorPublisher() == null) {
			return true;
		}
		return false;
	}
}
