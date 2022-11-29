package webapp.geektext.repos;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import webapp.geektext.entities.Book;
import java.util.List;
import java.util.Map;

/**
 * Browsing and sorting repository. Implements various functions
 * for sorting and retrieval.
 */
@Repository
public interface BrowseAndSortRepo extends JpaRepository<Book, Long> {

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
     * Get all books ordered by ISBN.
     * @return All books by ISBN.
     */
    public List<Book> findAllByOrderByBookISBNAsc();

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
     * Finds all books by copies sold in descending order.
     * @return All books by copies sold in descending order.
     */
    public List<Book> findAllByOrderByBookCopiesSoldDesc();

    /**
     * Get books by a specified rating and above (as well as the average rating of the book itself).
     * *Database is queried using a native query*
     * @param rating Specified rating to begin search by
     * @return Books by given rating and above.
     */
    @Query(value =
            "SELECT book_isbn AS \"bookISBN\", average_rating AS \"averageRating\", book_name AS \"bookName\", " +
            "book_description AS \"bookDescription\", book_price AS \"bookPrice\", book_author_id AS \"authorID\", book_genre AS \"bookGenre\", " +
            "book_publisher AS \"bookPublisher\", book_year_published AS \"yearPublished\", book_copies_sold AS \"copiesSold\"" +
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
            "WHERE average_rating >= :rating " +
            "ORDER BY average_rating ASC", nativeQuery = true)
    public List<Map<String, Object>> findByRatingAndHigher(int rating);
}