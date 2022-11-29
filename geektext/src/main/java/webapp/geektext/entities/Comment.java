package webapp.geektext.entities;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="comment")
@IdClass(CommentId.class)
public class Comment{

	@Id
	@Column(name = "comment_book_isbn")
	private long commentBookISBN;
	
	@Column(name = "comment_datestamp")
	private Date commentDatestamp;
	
	@Id
	@Column(name = "comment_user_id")
	private String commentUserId;
	
	@Column(name = "comment_details")
	private String commentDetails;

	
	//Constructors
	public Comment(long commentBookISBN, Date commentDatestamp, String commentUserId,
			String commentDetails) {
		super();
		this.commentBookISBN = commentBookISBN;
		this.commentDatestamp = commentDatestamp;
		this.commentUserId = commentUserId;
		this.commentDetails = commentDetails;
	}
	
	public Comment(){
		
	}

	
	//Getters and Setters
	public long getCommentBookISBN() {
		return commentBookISBN;
	}

	public void setCommentBookISBN(long commentBookISBN) {
		this.commentBookISBN = commentBookISBN;
	}

	public Date getCommentDatestamp() {
		return commentDatestamp;
	}

	public void setCommentDatestamp(Date commentDatestamp) {
		this.commentDatestamp = commentDatestamp;
	}

	public String getCommentUserId() {
		return commentUserId;
	}

	public void setCommentUserId(String commentUserId) {
		this.commentUserId = commentUserId;
	}

	public String getCommentDetails() {
		return commentDetails;
	}

	public void setCommentDetails(String commentDetails) {
		this.commentDetails = commentDetails;
	}
	
}
