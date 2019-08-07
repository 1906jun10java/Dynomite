package com.revature.beans;

public class Channel {
	
	private int channelID;
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
