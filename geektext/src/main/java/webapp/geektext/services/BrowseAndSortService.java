package webapp.geektext.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import webapp.geektext.entities.Book;
import webapp.geektext.repos.BrowseAndSortRepo;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Service that maintains several browsing and sorting operations.
 */
@Service
public class BrowseAndSortService {

    private final BrowseAndSortRepo browseAndSortRepo;

    @Autowired
    public BrowseAndSortService(BrowseAndSortRepo browseAndSortRepo) {
        this.browseAndSortRepo = browseAndSortRepo;
    }

    /**
     * Find books by genre.
     * @param genre Book genre.
     * @return All books by genre.
     */
    public List<Book> findByGenre(String genre) {
        // Check if book genre exists in database.
        if(!browseAndSortRepo.existsByBookGenreIgnoreCase(genre))
            throw new ResponseStatusException
                    (HttpStatus.NOT_FOUND, "Books of genre " + genre + " were not found.");

        return browseAndSortRepo.findByBookGenreIgnoreCaseOrderByBookName(genre);
    }

    /**
     * Find top-selling books.
     * This is a legacy method and used for debugging purposes.
     * Use findByTopSelling2 for implementation.
     * @param topNum Top-selling value.
     * @return Books by top sellers.
     */
    @Deprecated
    public List<Book> findByTopSelling(String topNum) {
        int topSellingNum;
        // See if topNum is an integer.
        try {
            topSellingNum = Integer.parseInt(topNum);
        }
        catch (NumberFormatException e) {
            throw new ResponseStatusException
                    (HttpStatus.BAD_REQUEST, "Invalid input");
        }

        // Value requested must be greater than 1.
        if (topSellingNum < 1)
            throw new ResponseStatusException
                    (HttpStatus.BAD_REQUEST, "Top selling value must be 1 or greater.");

        return browseAndSortRepo.topSelling(PageRequest.of(0,topSellingNum));
    }

    /**
     * Find top-selling books.
     * @param topNum Top-selling value.
     * @return Books by top sellers.
     */
    public List<Book> findByTopSelling2(String topNum) {
        List<Book> booksByNumSold = browseAndSortRepo.findAllByOrderByBookCopiesSoldDesc();
        List<Book> topSoldBooks = new LinkedList<>();
        int topSellingNum;

        if (booksByNumSold.isEmpty())
            throw new ResponseStatusException
                    (HttpStatus.NOT_FOUND, "No books were found.");

        // See if topNum is an integer.
        try {
            topSellingNum = Integer.parseInt(topNum) - 1;
        }
        catch (NumberFormatException e) {
            throw new ResponseStatusException
                    (HttpStatus.BAD_REQUEST, "Invalid input.");
        }

        // Value requested must be greater than 1.
        if (topSellingNum < 1)
            throw new ResponseStatusException
                    (HttpStatus.BAD_REQUEST, "Top selling value must be 1 or greater.");

        for (int i = 0; i < topSellingNum; i++) {
            topSoldBooks.add(booksByNumSold.get(i));
        }

        return topSoldBooks;
    }

    /**
     * Find books by rating and higher (and display rating for book).
     * @param num Value to begin search from.
     * @return Books by indicated rating.
     */
    public List<Map<String, Object>> findByRating(String num) {
        int rating;
        // See if num is an integer.
        try {
            rating = Integer.parseInt(num);
        }
        catch (NumberFormatException e) {
            throw new ResponseStatusException
                    (HttpStatus.BAD_REQUEST, "Invalid input");
        }

        // Rating must be between 1 and 5.
        if (rating < 1 || rating > 5)
            throw new ResponseStatusException
                    (HttpStatus.BAD_REQUEST, "Rating must be between 1 and 5");

        return browseAndSortRepo.findByRatingAndHigher(rating);
    }

    /**
     * Find a given number of books beginning from a given offset value.
     * @param stringNumBooks Number of books to search for.
     * @param stringOffset Beginning search value.
     * @return A given number of books from a given offset value.
     */
    public List<Book> findBooksFromOffset(String stringNumBooks, String stringOffset) {
        List<Book> allBooks = browseAndSortRepo.findAllByOrderByBookISBNAsc();  // All books by ISBN
        List<Book> numBooksByOffset = new LinkedList<>();   // Stores books

        // To store parameter values as ints.
        int numBooks;
        int offset;

        // Check if books exist.
        if (allBooks.isEmpty())
            throw new ResponseStatusException
                    (HttpStatus.NOT_FOUND, "No books were found.");

        try {   // Convert string parameters to int.
            numBooks = Integer.parseInt(stringNumBooks);
            offset = Integer.parseInt(stringOffset) - 1;
        }
        catch (NumberFormatException e) {
            throw new ResponseStatusException
                    (HttpStatus.BAD_REQUEST, "Number of books or offset is/are not integers");
        }

        // Must search for at least one book with an offset of at least 0.
        if (numBooks < 1 || offset < 0)
            throw new ResponseStatusException
                    (HttpStatus.BAD_REQUEST, "Number of books or offset is invalid");

        // Check if offset is larger than books present.
        else if (offset > allBooks.size())
            throw new ResponseStatusException
                    (HttpStatus.BAD_REQUEST, "Offset amount is larger than the record set.");

        // Return books from offset until desired amount is reached
        // Or until the end of the list if numBooks goes over the
        // record set from a given offset.
        for (int i = 0; i < numBooks; i++) {
            if (offset < allBooks.size())
                numBooksByOffset.add(allBooks.get(offset++));
            else
                break;
        }
        return numBooksByOffset;
    }
}