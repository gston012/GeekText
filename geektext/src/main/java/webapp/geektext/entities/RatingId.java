package webapp.geektext.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Id;

public class RatingId implements Serializable{
	
	private long ratingBookISBN;
	private String ratingUserId;
	
	public RatingId() {
		
	}
	
	public RatingId(long ratingBookISBN, String ratingUserId) {
		this.ratingBookISBN = ratingBookISBN;
		this.ratingUserId = ratingUserId;
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RatingId ratingId = (RatingId) o;
        return ratingBookISBN == ratingId.ratingBookISBN &&
                ratingUserId.equals(ratingId.ratingUserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ratingBookISBN, ratingUserId);
    }
}