package webapp.geektext.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webapp.geektext.entities.Shopping_cart;

@Repository
public interface Shopping_cartRepo extends JpaRepository<Shopping_cart,String> {

}
