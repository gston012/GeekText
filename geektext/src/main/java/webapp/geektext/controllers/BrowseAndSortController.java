package webapp.geektext.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webapp.geektext.entities.Book;
import webapp.geektext.services.BrowseAndSortService;
import java.util.List;

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
     * @param genre Book genre
     * @return All books by genre.
     */
    @GetMapping("/{genre}")
    public List<Book> findByGenre(@PathVariable String genre) {
        return browseAndSort.findByGenre(genre);
    }

    /**
     * Find top-selling books.
     * @param topNum Top-selling value
     * @return Books by top sellers
     */
    @GetMapping("/top{topNum}")
    public List<Book> findByTopSelling(@PathVariable String topNum) {
        return browseAndSort.findByTopSelling(topNum);
    }
}