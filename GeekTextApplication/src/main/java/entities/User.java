package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "user")
public class User {
	
	@Id
	@Column(name = "user_email")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String user_email;
	
	@Column(name = "user_password")
	private String user_password;
	
	@Column(name = "user_firstname")
	private String user_firstName;
	
	@Column(name = "user_lastname")
	private String user_lastName;
	
	@Column(name = "user_homeAddress")
	private String user_homeAddress;
	
	public User(String user_email, String user_password, String user_firstName, String user_lastName,
			String user_homeAddress) {
		super();
		this.user_email = user_email;
		this.user_password = user_password;
		this.user_firstName = user_firstName;
		this.user_lastName = user_lastName;
		this.user_homeAddress = user_homeAddress;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_firstName() {
		return user_firstName;
	}

	public void setUser_firstName(String user_firstName) {
		this.user_firstName = user_firstName;
	}

	public String getUser_lastName() {
		return user_lastName;
	}

	public void setUser_lastName(String user_lastName) {
		this.user_lastName = user_lastName;
	}

	public String getUser_homeAddress() {
		return user_homeAddress;
	}

	public void setUser_homeAddress(String user_homeAddress) {
		this.user_homeAddress = user_homeAddress;
	}

	@Override
	public String toString() {
		return "User [user_email=" + user_email + ", user_password=" + user_password + ", user_firstName="
				+ user_firstName + ", user_lastName=" + user_lastName + ", user_homeAddress=" + user_homeAddress + "]";
	}

	
}
