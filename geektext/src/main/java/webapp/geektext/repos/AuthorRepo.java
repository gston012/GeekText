package webapp.geektext.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import webapp.geektext.entities.Author;

public interface AuthorRepo extends JpaRepository<Author, Long> {

}
