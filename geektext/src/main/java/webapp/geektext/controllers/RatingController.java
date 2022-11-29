package webapp.geektext.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import webapp.geektext.entities.Rating;
import webapp.geektext.repos.RatingRepo;
import webapp.geektext.services.RatingService;

@RestController
public class RatingController {

	
	@Autowired
	RatingService ratingService;
	
	@GetMapping("/ratings")
	public List<Rating> getRatings() {
		return ratingService.getRatings();
	}
	
	@GetMapping("/sortedratings")
	public List<Rating> getSortedRatings() {
		return ratingService.getSortedRatings();
	}
	
	@GetMapping("/{ratings:(?i)ratings}/{average:(?i)average}/{bookISBN}")
	public ResponseEntity<Double> getAverageRating(@PathVariable("bookISBN") Long bookISBN) {
		return ratingService.getAverageRating(bookISBN);
	}
	
	@GetMapping("/{ratings:(?i)ratings}/{byuserId:(?i)byuserId}/{userId}")
	public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable("userId") String userId) {
		return ratingService.getRatingsByUserId(userId);
	}
	
	@PostMapping("/addrating")
	public Rating addRating(@RequestBody Rating rating) {
		return ratingService.addRating(rating);
	}
	
}
