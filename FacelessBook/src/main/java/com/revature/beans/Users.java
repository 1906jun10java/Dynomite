package com.revature.beans;


public class Users {
	
	private int UserID;
	private String firstName;
	private String lastName;
	private String username;
	private int moderatorStatus;
	private int access;
	private String email;
	
	public Users() {
		super();
	}
	
	

	public Users(int userID, String firstName, String lastName, String username, int moderatorStatus, int access, String email) {
		super();
		UserID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + moderatorStatus;
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
		Users other = (Users) obj;
		if (UserID != other.UserID)
			return false;
		if (access != other.access)
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
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}





	@Override
	public String toString() {
		return "Users [UserID=" + UserID + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + ", moderatorStatus=" + moderatorStatus + ", access=" + access + ", email=" + email + "]";
	}
	
	
	
	

}
