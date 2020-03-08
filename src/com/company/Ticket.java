package com.company;

import java.util.Date;

public class Ticket {
	protected int ticketID;
	protected int roomID;
	protected Date openTime;
	protected boolean complete;
	private String description;

    //Constructor
    public Ticket(String description, int roomID, Date openTime, boolean complete)
    {
        this.complete = complete;
        this.setDescription(description);
        this.roomID = roomID;
        this.openTime = openTime;
    }
    
    public void closeTicket() 
    {
    	complete = true;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
    
}
