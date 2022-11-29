package webapp.geektext.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import webapp.geektext.entities.Comment;
import webapp.geektext.entities.Rating;
import webapp.geektext.repos.CommentRepo;
import webapp.geektext.services.CommentService;

@RestController
public class CommentController {

	
	@Autowired
	CommentService commentService;
	
	@GetMapping("/comments")
	public List<Comment> getComments() {
		return commentService.getComments();
	}
	
	@GetMapping("/{comments:(?i)comments}/{byuserid:(?i)byuserid}/{userId}")
	public ResponseEntity<List<Comment>> getCommentsByUserId(@PathVariable("userId") String userId) {
		return commentService.getCommentsByUserId(userId);
	}
	
	@PostMapping("/addcomment")
	public Comment addComment(@RequestBody Comment comment) {
		return commentService.addComment(comment);
	}
	
}
