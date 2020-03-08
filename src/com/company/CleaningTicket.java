package com.company;

public class CleaningTicket {
    private int roomID;
    private boolean complete;
    private String description;
    
    public CleaningTicket(int roomID, boolean complete, String description) 
    {
    	this.roomID = roomID;
    	this.complete = complete;
    	this.description = description;
    }
    
	public int getRoomID() {
		return roomID;
	}
	
	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
