package webapp.geektext.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

	
	@Id
	@Column(name = "book_isbn")
	private long bookISBN;
	
	@Column(name = "book_name")
	private String bookName;
	
	@Column(name = "book_description")
	private String bookDescription;
	
	@Column(name = "book_price")
	private double bookPrice;
	
	@Column(name = "book_author_id")
	private long bookAuthorId;
	
	@Column(name = "book_genre")
	private String bookGenre;
	
	@Column(name = "book_publisher")
	private String bookPublisher;
	
	@Column(name = "book_year_published")
	private int bookYearPublished;
	
	@Column(name = "book_copies_sold")
	private int bookCopiesSold;


	//Constructor
	public Book(long bookISBN, String bookName, String bookDescription, double bookPrice, long bookAuthorId,
			String bookGenre, String bookPublisher, int bookYearPublished, int bookCopiesSold) {
		super();
		this.bookISBN = bookISBN;
		this.bookName = bookName;
		this.bookDescription = bookDescription;
		this.bookPrice = bookPrice;
		this.bookAuthorId = bookAuthorId;
		this.bookGenre = bookGenre;
		this.bookPublisher = bookPublisher;
		this.bookYearPublished = bookYearPublished;
		this.bookCopiesSold = bookCopiesSold;
	}
	
	public Book() {
		
	}
}