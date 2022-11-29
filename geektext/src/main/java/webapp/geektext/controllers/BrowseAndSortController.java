package webapp.geektext.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webapp.geektext.entities.Book;
import webapp.geektext.services.BrowseAndSortService;
import java.util.List;
import java.util.Map;

/**
 * Controller for book browsing and sorting.
 */
@RestController
@RequestMapping("/books")
public class BrowseAndSortController {

    private final BrowseAndSortService browseAndSort;

    @Autowired
    public BrowseAndSortController(BrowseAndSortService browseAndSort) {
        this.browseAndSort = browseAndSort;
    }

    /**
     * Find books by genre.
     * @param genre Book genre.
     * @return All books by genre.
     */
    @GetMapping("/genre/{genre}")
    public List<Book> findByGenre(@PathVariable String genre) {
        return browseAndSort.findByGenre(genre);
    }

    /**
     * Find top-selling books.
     * @param topNum Top-selling value.
     * @return Books by top sellers.
     */
    @GetMapping("/top/{topNum}")
    public List<Book> findByTopSelling(@PathVariable String topNum) {
        return browseAndSort.findByTopSelling2(topNum);
    }

    /**
     * Find books by rating and higher (and display rating for book).
     * @param rating Rating of books.
     * @return Books by indicated rating.
     */
    @GetMapping("/rating/{rating}")
    public List<Map<String, Object>> findByRating(@PathVariable String rating) {
        return browseAndSort.findByRating(rating);
    }

    /**
     * Find a given number of books beginning from a given offset value.
     * @param numBooks Number of books to search for.
     * @param offset Beginning search value.
     * @return A given number of books from a given offset value.
     */
    @GetMapping("/get/{numBooks}/from/{offset}")
    public List<Book> findBooksFromOffset(@PathVariable String numBooks, @PathVariable String offset) {
        return browseAndSort.findBooksFromOffset(numBooks, offset);
    }
}