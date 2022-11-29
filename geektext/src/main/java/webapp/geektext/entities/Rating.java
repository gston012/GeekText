package webapp.geektext.entities;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="rating")
@IdClass(RatingId.class)
public class Rating {

	@Id
	@Column(name = "rating_book_isbn")
	private long ratingBookISBN;
	
	@Column(name = "rating_stars")
	private int ratingStars;
	
	@Column(name = "rating_datestamp")
	private Date ratingDatestamp;
	
	@Id
	@Column(name = "rating_user_id")
	private String ratingUserId;
	

	
	//Constructors
	public Rating(long ratingBookISBN, int ratingStars, Date ratingDatestamp, String ratingUserId) {
		super();
		this.ratingBookISBN = ratingBookISBN;
		this.ratingStars = ratingStars;
		this.ratingDatestamp = ratingDatestamp;
		this.ratingUserId = ratingUserId;
	}
	
	public Rating(){
		
	}

	
	//Getters and Setters
	public long getRatingBookISBN() {
		return ratingBookISBN;
	}

	public void setRatingBookISBN(long ratingBookISBN) {
		this.ratingBookISBN = ratingBookISBN;
	}
	
	public long getRatingStars() {
		return ratingStars;
	}

	public void setRatingStars(int ratingStars) {
		this.ratingStars = ratingStars;
	}

	public Date getRatingDatestamp() {
		return ratingDatestamp;
	}

	public void setRatingDatestamp(Date ratingDatestamp) {
		this.ratingDatestamp = ratingDatestamp;
	}

	public String getRatingUserId() {
		return ratingUserId;
	}

	public void setRatingUserId(String ratingUserId) {
		this.ratingUserId = ratingUserId;
	}

}
