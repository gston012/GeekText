package webapp.geektext.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Id;

public class CommentId implements Serializable{
	
	private long commentBookISBN;
	private String commentUserId;
	
	public CommentId() {
		
	}
	
	public CommentId(long commentBookISBN, String commentUserId) {
		this.commentBookISBN = commentBookISBN;
		this.commentUserId = commentUserId;
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentId commentId = (CommentId) o;
        return commentBookISBN == commentId.commentBookISBN &&
                commentUserId.equals(commentId.commentUserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentBookISBN, commentUserId);
    }
}
