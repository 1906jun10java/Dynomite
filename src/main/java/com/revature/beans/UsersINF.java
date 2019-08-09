package com.revature.beans;

public class UsersINF {

	// Info class for JSON data transfer ONLY
	private String firstName;
	private String lastName;
	private String username;
	private int moderatorStatus;
	private int accessPermission;
	private String email;
	private String imageURL;
	
	public UsersINF(String firstName, String lastName, String username, int moderatorStatus, int accessPermission,
			String email, String imageURL) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.moderatorStatus = moderatorStatus;
		this.accessPermission = accessPermission;
		this.email = email;
		this.imageURL = imageURL;
	}

	public UsersINF() {
		super();
	}
	
	public String getImageURL() {
		return imageURL;
	}


	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
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

	public int getAccessPermission() {
		return accessPermission;
	}

	public void setAccessPermission(int accessPermission) {
		this.accessPermission = accessPermission;
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
		result = prime * result + accessPermission;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((imageURL == null) ? 0 : imageURL.hashCode());
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
		UsersINF other = (UsersINF) obj;
		if (accessPermission != other.accessPermission)
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
		if (imageURL == null) {
			if (other.imageURL != null)
				return false;
		} else if (!imageURL.equals(other.imageURL))
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
		return "UsersINF [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", moderatorStatus=" + moderatorStatus + ", accessPermission=" + accessPermission + ", email=" + email
				+ ", imageURL=" + imageURL + "]";
	}
	
	
}
