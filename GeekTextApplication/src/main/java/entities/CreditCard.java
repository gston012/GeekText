package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Credit Card")
public class CreditCard {
	
	@Id
	@Column(name = "credit_card_Number")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String credit_card_Number;
	
	@Column(name = "credit_card_userID")
	private String credit_card_userID;
	
	@Column(name = "credit_card_expMonth")
	private int credit_card_expMonth;
	
	@Column(name = "credit_card_expYear")
	private int credit_card_expYear;
	
	
	public CreditCard(String credit_card_Number, String credit_card_userID, int credit_card_expMonth,
			int credit_card_expYear) {
		super();
		this.credit_card_Number = credit_card_Number;
		this.credit_card_userID = credit_card_userID;
		this.credit_card_expMonth = credit_card_expMonth;
		this.credit_card_expYear = credit_card_expYear;
	}


	public String getCredit_card_Number() {
		return credit_card_Number;
	}


	public void setCredit_card_Number(String credit_card_Number) {
		this.credit_card_Number = credit_card_Number;
	}


	public String getCredit_card_userID() {
		return credit_card_userID;
	}


	public void setCredit_card_userID(String credit_card_userID) {
		this.credit_card_userID = credit_card_userID;
	}


	public int getCredit_card_expMonth() {
		return credit_card_expMonth;
	}


	public void setCredit_card_expMonth(int credit_card_expMonth) {
		this.credit_card_expMonth = credit_card_expMonth;
	}


	public int getCredit_card_expYear() {
		return credit_card_expYear;
	}


	public void setCredit_card_expYear(int credit_card_expYear) {
		this.credit_card_expYear = credit_card_expYear;
	}


	@Override
	public String toString() {
		return "CreditCard [credit_card_Number=" + credit_card_Number + ", credit_card_userID=" + credit_card_userID
				+ ", credit_card_expMonth=" + credit_card_expMonth + ", credit_card_expYear=" + credit_card_expYear
				+ "]";
	}
	
	

}
