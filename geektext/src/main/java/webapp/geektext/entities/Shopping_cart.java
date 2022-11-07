package webapp.geektext.entities;

import javax.persistence.*;

@Entity
@Table(name = "shopping_cart")
public class Shopping_cart {

    @Id
    @Column(name = "shopping_cart_user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String shoppingcartID;

    @Column(name = "shopping_cart_books")
    private long shoppingcartBooks;

    public String getShoppingcartID() {
        return shoppingcartID;
    }

    public void setShoppingcartID(String shoppingcartID) {
        this.shoppingcartID = shoppingcartID;
    }

    public long getShoppingcartBooks() {
        return shoppingcartBooks;
    }

    public void setShoppingcartBooks(long shoppingcartBooks) {
        this.shoppingcartBooks = shoppingcartBooks;
    }

    public Shopping_cart(String shoppingcartID, long shoppingcartBooks) {
        this.shoppingcartID = shoppingcartID;
        this.shoppingcartBooks = shoppingcartBooks;
    }
    
    @Override
    public String toString() {
        return "Shopping_cart{" +
                "shoppingcartID='" + shoppingcartID + '\'' +
                ", shoppingcartBooks=" + shoppingcartBooks +
                '}';
    }

    public void Shopping_cart(){

    }


}
