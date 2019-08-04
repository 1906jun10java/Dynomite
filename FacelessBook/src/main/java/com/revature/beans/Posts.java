package com.revature.beans;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "POSTS")
public class Posts {
	
	public Posts() {
		super();
	}
	
	public Posts(int postID, String content, Users user, int channelID, int likes, int commentID) {
		super();
		this.postID = postID;
		this.content = content;
		this.users = user;
		this.channelID = channelID;
		this.likes = likes;
		this.commentID = commentID;
	}

	public Posts(String content, Users user, int channelID, int likes, int commentID) {
		super();
		this.content = content;
		this.users = user;
		this.channelID = channelID;
		this.likes = likes;
		this.commentID = commentID;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "postsSequence")
	@SequenceGenerator(allocationSize = 1, name = "postsSequence", sequenceName = "SQ_POSTS_PK")
	@Column(name = "POST_ID")
	private int postID;
	@Column(name = "CONTENT")
	private String content;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	@JoinColumn(name="USER_ID")
	private Users users;
	@Column(name = "CHANNEL_ID")
	private int channelID;
	@Column(name = "LIKES")
	private int likes;
	@Column(name = "COMMENT_ID")
	private int commentID;
	@Column(name = "TIME_STAMP")
	private Timestamp timeStamp;

	
	
	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

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

	public int getCommentID() {
		return commentID;
	}

	public void setCommentID(int commentID) {
		this.commentID = commentID;
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
		result = prime * result + commentID;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + likes;
		result = prime * result + postID;
		result = prime * result + ((users == null) ? 0 : users.hashCode());
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
		if (commentID != other.commentID)
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
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Posts [postID=" + postID + ", content=" + content + ", user=" + users + ", channelID=" + channelID
				+ ", likes=" + likes + ", commentID=" + commentID + "]";
	}
	
	
	

}
