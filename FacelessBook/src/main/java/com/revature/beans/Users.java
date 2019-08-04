package com.revature.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "usersSequence")
	@SequenceGenerator(allocationSize = 1, name = "usersSequence", sequenceName = "SQ_USERS_PK")
	@Column(name = "USER_ID")
	private int UserID;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@OneToOne
	@JoinColumn(name="USERNAME")
	private Credentials credentials;
	@Column(name = "MOD_STATUS")
	private int moderatorStatus;
	@Column(name = "ACCESS_PERMISSION")
	private int access;
	@Column(name = "EMAIL")
	private String email;
	
	public Users() {
		super();
	}
	 
	public Users(int userID, String firstName, String lastName, Credentials credentials, int moderatorStatus,
			int access, String email) {
		super();
		UserID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.credentials = credentials;
		this.moderatorStatus = moderatorStatus;
		this.access = access;
		this.email = email;
	}

	public Users(String firstName, String lastName, Credentials credentials, int moderatorStatus, int access,
			String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.credentials = credentials;
		this.moderatorStatus = moderatorStatus;
		this.access = access;
		this.email = email;
	}

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		UserID = userID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

	public int getModeratorStatus() {
		return moderatorStatus;
	}

	public void setModeratorStatus(int moderatorStatus) {
		this.moderatorStatus = moderatorStatus;
	}

	public int getAccess() {
		return access;
	}

	public void setAccess(int access) {
		this.access = access;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + UserID;
		result = prime * result + access;
		result = prime * result + ((credentials == null) ? 0 : credentials.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + moderatorStatus;
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
		Users other = (Users) obj;
		if (UserID != other.UserID)
			return false;
		if (access != other.access)
			return false;
		if (credentials == null) {
			if (other.credentials != null)
				return false;
		} else if (!credentials.equals(other.credentials))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (moderatorStatus != other.moderatorStatus)
			return false;
		return true;
	}





	@Override
	public String toString() {
		return "Users [UserID=" + UserID + ", firstName=" + firstName + ", lastName=" + lastName + ", credentials="
				+ credentials + ", moderatorStatus=" + moderatorStatus + ", access=" + access + ", email=" + email
				+ "]";
	}
	
	
	
	

}
