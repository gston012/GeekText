package webapp.geektext.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import webapp.geektext.entities.Comment;
import webapp.geektext.entities.Rating;
import webapp.geektext.repos.CommentRepo;

@Service
public class CommentService {

	@Autowired CommentRepo commentRepo;
	public CommentService() {
		
	}
	
	public List<Comment> getComments(){
		return commentRepo.findAll();
	}
	
	public ResponseEntity<List<Comment>> getCommentsByUserId(String UserId) {
		List<Comment> commentListToReturn = new ArrayList<Comment>(); // comment List to Return
		List<Comment> commentsToSearch = commentRepo.findAll();
		
		for (Comment comment : commentsToSearch) {
			if(comment.getCommentUserId().equals(UserId)) {
				commentListToReturn.add(comment);
			}
		}
		if(commentListToReturn.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<List<Comment>>(commentListToReturn, HttpStatus.OK);
		}
	}
	
	public Comment addComment(Comment comment) {
		return commentRepo.save(comment);
	}
}
