package webapp.geektext.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import webapp.geektext.entities.Rating;
import webapp.geektext.entities.RatingId;

public interface RatingRepo extends JpaRepository<Rating, RatingId> {

}
