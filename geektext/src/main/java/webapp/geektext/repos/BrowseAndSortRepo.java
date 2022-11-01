package webapp.geektext.repos;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import webapp.geektext.entities.Book;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Browsing and sorting repository. Implements various retrieval functions
 * for sorting.
 */
@Repository
public interface BrowseAndSortRepo extends JpaRepository<Book, BigDecimal> {

    /**
     * Query derivation for a book search by genre.
     * @param bookGenre Book genre
     * @return If a book by a certain genre exists
     */
    public Boolean existsByBookGenreIgnoreCase(String bookGenre);

    /**
     * Retrieves all books of a certain genre, case-insensitive
     * @param genre Book genre
     * @return All books of a certain genre
     */
    public List<Book> findByBookGenreIgnoreCaseOrderByBookName(String genre);

    /**
     * Get top 10 most sold books.
     * SQL: SELECT book_copies_sold, book_name FROM book ORDER BY book_copies_sold DESC LIMIT 10
     * LIMIT not supported by JPQL; collect rows through PageRequest.
     * @param pageRequest Amount of top values to display
     * @return Books by specified top value.
     */
    @Query( "SELECT b " +
            "FROM Book b " +
            "ORDER BY b.bookCopiesSold DESC")
    public List<Book> topSelling(PageRequest pageRequest);

    /**
     * Get books by a specified rating and above (as well as the average rating of the book itself).
     * @param rating Specified rating to begin search by
     * @return Books by given rating and above.
     */
    @Query(value =
            "SELECT book_isbn, average_rating, book_name, book_description, book_price, " +
                   "book_author_id, book_genre, book_publisher, book_year_published, book_copies_sold " +
            "FROM " +
            "(SELECT rating_book_isbn, cast(AVG(rating_stars) AS DEC(3,1)) AS Average_Rating " +
            "FROM rating " +
            "GROUP BY rating_book_isbn) " +
            "t1 " +
            "INNER JOIN " +
            "(SELECT * " +
            "FROM book) " +
            "t2 " +
            "ON t1.rating_book_isbn = t2.book_isbn " +
            "WHERE average_rating > :rating " +
            "ORDER BY average_rating ASC", nativeQuery = true)
    public List<Map<String, Object>> findByRatingAndHigher(int rating);

    //***IGNORE FOR NOW***
//    // Projection for genre data
//    interface GenreProjection {
//        String getBookGenre();
//        String getBookName();
//    }
//    // Projection for number of books sold.
//    interface SoldProjection {
//        int getBookCopiesSold();
//        String getBookName();
//    }
//
//    /**
//     * Get books by genre
//     * SQL: SELECT book_name, book_genre FROM book ORDER BY book_genre
//     */
//    @Query( "SELECT b.bookName as bookName, b.bookGenre as bookGenre " +
//            "FROM Book b " +
//            "ORDER BY b.bookGenre")
//    public List<GenreProjection> findByGenre();
}