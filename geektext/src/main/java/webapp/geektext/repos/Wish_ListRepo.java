package webapp.geektext.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webapp.geektext.entities.Wish_List;

@Repository
public interface Wish_ListRepo extends JpaRepository<Wish_List,Long> {

}