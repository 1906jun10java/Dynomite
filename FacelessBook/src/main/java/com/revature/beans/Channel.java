package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CHANNEL")
public class Channel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "channelSequence")
	@SequenceGenerator(allocationSize = 1, name = "channelSequence", sequenceName = "SQ_CHANNEL_PK")
	@Column(name = "CHANNEL_ID")
	private int channelID;
	@Column(name = "CHANNEL_NAME")
	private String channelName;
	
	public Channel() {
		super();
	}

	public Channel(int channelID, String channelName) {
		super();
		this.channelID = channelID;
		this.channelName = channelName;
	}

	public int getChannelID() {
		return channelID;
	}

	public void setChannelID(int channelID) {
		this.channelID = channelID;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + channelID;
		result = prime * result + ((channelName == null) ? 0 : channelName.hashCode());
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
		Channel other = (Channel) obj;
		if (channelID != other.channelID)
			return false;
		if (channelName == null) {
			if (other.channelName != null)
				return false;
		} else if (!channelName.equals(other.channelName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Channel [channelID=" + channelID + ", channelName=" + channelName + "]";
	}
	
	

}
