package java.com.revature.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tickets")
public class User {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "user_id")
	private int ID; 
	
	@Column(name = "registration_timestamp")
	private Timestamp registered;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "credit_card_number")
	private int cardnumber;
	
	@Column(name = "expiration_month")
	private int expirationmonth;
	
	@Column(name = "expiration_year")
	private int expirationyear;
	
	@Column(name = "security_code")
	private int securitycode;
	
	@Column(name = "birthday_day")
	private int birthday;
	
	@Column(name = "birthday_month")
	private int birthmonth;
	
	@Column(name = "birthday_year")
	private int birthyear;
	
	@Column(name = "email")
	private String email;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + birthday;
		result = prime * result + birthmonth;
		result = prime * result + birthyear;
		result = prime * result + cardnumber;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + expirationmonth;
		result = prime * result + expirationyear;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((registered == null) ? 0 : registered.hashCode());
		result = prime * result + securitycode;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (ID != other.ID)
			return false;
		if (birthday != other.birthday)
			return false;
		if (birthmonth != other.birthmonth)
			return false;
		if (birthyear != other.birthyear)
			return false;
		if (cardnumber != other.cardnumber)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (expirationmonth != other.expirationmonth)
			return false;
		if (expirationyear != other.expirationyear)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (registered == null) {
			if (other.registered != null)
				return false;
		} else if (!registered.equals(other.registered))
			return false;
		if (securitycode != other.securitycode)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [ID=" + ID + ", registered=" + registered + ", username=" + username + ", password=" + password
				+ ", cardnumber=" + cardnumber + ", expirationmonth=" + expirationmonth + ", expirationyear="
				+ expirationyear + ", securitycode=" + securitycode + ", birthday=" + birthday + ", birthmonth="
				+ birthmonth + ", birthyear=" + birthyear + ", email=" + email + "]";
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Timestamp getRegistered() {
		return registered;
	}

	public void setRegistered(Timestamp registered) {
		this.registered = registered;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(int cardnumber) {
		this.cardnumber = cardnumber;
	}

	public int getExpirationmonth() {
		return expirationmonth;
	}

	public void setExpirationmonth(int expirationmonth) {
		this.expirationmonth = expirationmonth;
	}

	public int getExpirationyear() {
		return expirationyear;
	}

	public void setExpirationyear(int expirationyear) {
		this.expirationyear = expirationyear;
	}

	public int getSecuritycode() {
		return securitycode;
	}

	public void setSecuritycode(int securitycode) {
		this.securitycode = securitycode;
	}

	public int getBirthday() {
		return birthday;
	}

	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}

	public int getBirthmonth() {
		return birthmonth;
	}

	public void setBirthmonth(int birthmonth) {
		this.birthmonth = birthmonth;
	}

	public int getBirthyear() {
		return birthyear;
	}

	public void setBirthyear(int birthyear) {
		this.birthyear = birthyear;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
