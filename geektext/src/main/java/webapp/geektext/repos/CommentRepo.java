package webapp.geektext.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import webapp.geektext.entities.Comment;
import webapp.geektext.entities.CommentId;

public interface CommentRepo extends JpaRepository<Comment, CommentId> {

}
