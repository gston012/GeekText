package webapp.geektext.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webapp.geektext.entities.Author;
import webapp.geektext.repos.AuthorRepo;

@Service
public class AuthorService {

	@Autowired AuthorRepo authorRepo;
	public AuthorService() {
		
	}
	
	public List<Author> getAuthors(){
		return authorRepo.findAll();
	}
}
