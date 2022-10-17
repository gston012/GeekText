package webapp.geektext.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import webapp.geektext.entities.Book;
import webapp.geektext.repos.BrowseAndSortRepo;
import java.util.List;


@Service
/**
 * Service that maintains several browsing and sorting operations.
 */
public class BrowseAndSortService {

//    public ResponseEntity getAllBooks() {
//        return ResponseEntity.ok(this.browseAndSortRepo.findAll());
//    }

    private final BrowseAndSortRepo browseAndSortRepo;

    @Autowired
    public BrowseAndSortService(BrowseAndSortRepo browseAndSortRepo) {
        this.browseAndSortRepo = browseAndSortRepo;
    }

    /**
     * Find books by genre.
     * @param genre Book genre
     * @return All books by genre.
     */
    public List<Book> findByGenre(String genre) {
        if(!browseAndSortRepo.existsByBookGenreIgnoreCase(genre))
            throw new ResponseStatusException
                    (HttpStatus.NOT_FOUND, "Books of genre " + genre + " were not found.");

        return browseAndSortRepo.findByBookGenreIgnoreCaseOrderByBookName(genre);
    }

    /**
     * Find top-selling books.
     * @param topNum Top-selling value
     * @return Books by top sellers
     */
    public List<Book> findByTopSelling(String topNum) {
        int checkedNum;
        // See if topNum is an integer.
        try {
            checkedNum = Integer.parseInt(topNum);
        }
        catch (NumberFormatException e) {
            throw new ResponseStatusException
                    (HttpStatus.BAD_REQUEST, "Invalid input");
        }
        return browseAndSortRepo.topSelling(PageRequest.of(0,checkedNum));
    }
}