package com.company;

public class MaintenanceTicket {
    private int roomID;
    private String description;
    private boolean complete;

    public MaintenanceTicket(int roomID, boolean complete, String description) 
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
