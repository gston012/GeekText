package webapp.geektext.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wishlist")
public class Wish_List {

    @Id
    @Column(name = "wishlist_name")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String wishlistID;

    @Column(name = "wishlist_book_id")
    private long wishlistBooks;

    public String wishlistID() {
        return wishlistID;
    }

    public void setwishlistID(String wishlistID) {
        this.wishlistID = wishlistID;
    }

    public long getwishlistBooks() {
        return wishlistBooks;
    }

    public void setwishlistBooks(long wishlistBooks) {
        this.wishlistBooks = wishlistBooks;
    }

    public Wish_List(String wishlistID, long wishlistBooks) {
        this.wishlistID= wishlistID;
        this.wishlistBooks = wishlistBooks;
    }


}
