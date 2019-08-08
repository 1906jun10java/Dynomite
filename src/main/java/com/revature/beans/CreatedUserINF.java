package com.revature.beans;

public class CreatedUserINF {

	// For use with taking in inputs from the front end ONLY
	private String firstName;
	private String lastName;
	private String username;
	private String pass;
	private int modStatus;
	private int accessPermission;
	private String email;
	private String imageURL;
	
	public CreatedUserINF(String firstName, String lastName, String username, String pass, int modStatus,
			int accessPermission, String email, String imageURL) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.pass = pass;
		this.modStatus = modStatus;
		this.accessPermission = accessPermission;
		this.email = email;
		this.imageURL = imageURL;
	}
	
	
	public String getImageURL() {
		return imageURL;
	}


	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}


	public CreatedUserINF() {
		super();
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

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getModStatus() {
		return modStatus;
	}

	public void setModStatus(int modStatus) {
		this.modStatus = modStatus;
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
		result = prime * result + modStatus;
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
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
		CreatedUserINF other = (CreatedUserINF) obj;
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
		if (modStatus != other.modStatus)
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
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
		return "CreatedUserINF [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", pass=" + pass + ", modStatus=" + modStatus + ", accessPermission=" + accessPermission + ", email="
				+ email + ", imageURL=" + imageURL + "]";
	}
	
	
	
	
}
