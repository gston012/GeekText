package webapp.geektext.entities;

import java.math.BigDecimal;
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
	private BigDecimal bookPrice;
	
	@Column(name = "book_author_id")
	private Long bookAuthorId;
	
	@Column(name = "book_genre")
	private String bookGenre;
	
	@Column(name = "book_publisher")
	private String bookPublisher;
	
	@Column(name = "book_year_published")
	private int bookYearPublished;
	
	@Column(name = "book_copies_sold")
	private int bookCopiesSold;


	//Constructor
	public Book(long bookISBN, String bookName, String bookDescription, BigDecimal bookPrice, long bookAuthorId,
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
	
	@Override
	public String toString() {
		return "Book [bookISBN=" + bookISBN + ", bookName=" + bookName + ", bookDescription=" + bookDescription
				+ ", bookPrice=" + bookPrice + ", bookAuthorId=" + bookAuthorId + ", bookGenre=" + bookGenre
				+ ", bookPublisher=" + bookPublisher + ", bookYearPublished=" + bookYearPublished + ", bookCopiesSold="
				+ bookCopiesSold + "]";
	}
	
	
	//Getters and Setters
	public long getBookISBN() {
		return bookISBN;
	}

	public void setBookISBN(long bookISBN) {
		this.bookISBN = bookISBN;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookDescription() {
		return bookDescription;
	}

	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}

	public BigDecimal getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(BigDecimal bookPrice) {
		this.bookPrice = bookPrice;
	}

	public Long getBookAuthorId() {
		return bookAuthorId;
	}

	public void setBookAuthorId(long bookAuthorId) {
		this.bookAuthorId = bookAuthorId;
	}

	public String getBookGenre() {
		return bookGenre;
	}

	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}

	public String getBookPublisher() {
		return bookPublisher;
	}

	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}

	public int getBookYearPublished() {
		return bookYearPublished;
	}

	public void setBookYearPublished(int bookYearPublished) {
		this.bookYearPublished = bookYearPublished;
	}

	public int getBookCopiesSold() {
		return bookCopiesSold;
	}

	public void setBookCopiesSold(int bookCopiesSold) {
		this.bookCopiesSold = bookCopiesSold;
	}
}