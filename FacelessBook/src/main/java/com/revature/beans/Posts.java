package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "POSTS")
public class Posts {
	
	public Posts() {
		super();
	}
	
	public Posts(int postID, String content, int userID, int channelID, int likes) {
		super();
		this.postID = postID;
		this.content = content;
		this.userID = userID;
		this.channelID = channelID;
		this.likes = likes;
	}
	
	public Posts(String content, int userID, int channelID, int likes) {
		super();
		this.content = content;
		this.userID = userID;
		this.channelID = channelID;
		this.likes = likes;
		
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "postsSequence")
	@SequenceGenerator(allocationSize = 1, name = "postsSequence", sequenceName = "SQ_POSTS_PK")
	@Column(name = "POST_ID")
	private int postID;
	@Column(name = "CONTENT")
	private String content;
	@Column(name = "USER_ID")
	private int userID;
	@Column(name = "CHANNEL_ID")
	private int channelID;
	@Column(name = "LIKES")
	private int likes;

	
	
	public int getPostID() {
		return postID;
	}


	public void setPostID(int postID) {
		this.postID = postID;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public int getUserID() {
		return userID;
	}


	public void setUserID(int userID) {
		this.userID = userID;
	}


	public int getChannelID() {
		return channelID;
	}


	public void setChannelID(int channelID) {
		this.channelID = channelID;
	}


	public int getLikes() {
		return likes;
	}


	public void setLikes(int likes) {
		this.likes = likes;
	}
	
	
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + channelID;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + likes;
		result = prime * result + postID;
		result = prime * result + userID;
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
		Posts other = (Posts) obj;
		if (channelID != other.channelID)
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (likes != other.likes)
			return false;
		if (postID != other.postID)
			return false;
		if (userID != other.userID)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Posts [postID=" + postID + ", content=" + content + ", userID=" + userID + ", channelID=" + channelID
				+ ", likes=" + likes + "]";
	}
	
	
	

}
