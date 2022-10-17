package webapp.geektext.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import webapp.geektext.entities.Book;

public interface BookRepo extends JpaRepository<Book, Long> {

}
