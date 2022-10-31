package webapp.geektext.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="author")
public class Author {

	@Id
	@Column(name = "author_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long authorId;
	
	@Column(name = "author_firstname")
	private String authorFirstName;
	
	@Column(name = "author_lastname")
	private String authorLastName;
	
	@Column(name = "author_biography")
	private String authorBiography;
	
	@Column(name = "author_publisher")
	private String authorPublisher;
	
	@Transient
	@Column(name = "author_full_name")
	private String authorFullName = authorFirstName + " " + authorLastName;
	

	//Constructors
	public Author(long authorId, String authorFirstName, String authorLastName, String authorBiography,
			String authorPublisher, String authorFullName) {
		super();
		this.authorId = authorId;
		this.authorFirstName = authorFirstName;
		this.authorLastName = authorLastName;
		this.authorBiography = authorBiography;
		this.authorPublisher = authorPublisher;
		this.authorFullName = authorFullName;
	}
	
	public Author(){
		
	}

	
	//Getters and Setters
	public long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(long authorId) {
		this.authorId = authorId;
	}

	public String getAuthorFirstName() {
		return authorFirstName;
	}

	public void setAuthorFirstName(String authorFirstName) {
		this.authorFirstName = authorFirstName;
	}

	public String getAuthorLastName() {
		return authorLastName;
	}

	public void setAuthorLastName(String authorLastName) {
		this.authorLastName = authorLastName;
	}

	public String getAuthorBiography() {
		return authorBiography;
	}

	public void setAuthorBiography(String authorBiography) {
		this.authorBiography = authorBiography;
	}

	public String getAuthorPublisher() {
		return authorPublisher;
	}

	public void setAuthorPublisher(String authorPublisher) {
		this.authorPublisher = authorPublisher;
	}
	
	public String getAuthorFullName() {
		return authorFullName;
	}

	public void setAuthorFullName(String authorFullName) {
		this.authorFullName = authorFullName;
	}
	
	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", authorFirstName=" + authorFirstName + ", authorLastName="
				+ authorLastName + ", authorBiography=" + authorBiography + ", authorPublisher=" + authorPublisher
				+ ", authorFullName=" + authorFullName + "]";
	}
}
