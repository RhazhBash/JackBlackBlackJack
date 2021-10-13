package com.revature.models;

import java.sql.Timestamp;
import java.util.Calendar;

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
	
	@Column(name = "expiration_date")
	private Calendar expirationdate;
	
	@Column(name = "security_code")
	private int securitycode;
	
	@Column(name = "birthday")
	private Calendar DOB;
	
	@Column(name = "email")
	private String email;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DOB == null) ? 0 : DOB.hashCode());
		result = prime * result + ID;
		result = prime * result + cardnumber;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((expirationdate == null) ? 0 : expirationdate.hashCode());
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
		if (DOB == null) {
			if (other.DOB != null)
				return false;
		} else if (!DOB.equals(other.DOB))
			return false;
		if (ID != other.ID)
			return false;
		if (cardnumber != other.cardnumber)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (expirationdate == null) {
			if (other.expirationdate != null)
				return false;
		} else if (!expirationdate.equals(other.expirationdate))
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
				+ ", cardnumber=" + cardnumber + ", expirationdate=" + expirationdate + ", securitycode=" + securitycode
				+ ", DOB=" + DOB + ", email=" + email + "]";
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

	public Calendar getExpirationdate() {
		return expirationdate;
	}

	public void setExpirationdate(Calendar expirationdate) {
		this.expirationdate = expirationdate;
	}

	public int getSecuritycode() {
		return securitycode;
	}

	public void setSecuritycode(int securitycode) {
		this.securitycode = securitycode;
	}

	public Calendar getDOB() {
		return DOB;
	}

	public void setDOB(Calendar dOB) {
		DOB = dOB;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
