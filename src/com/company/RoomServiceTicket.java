package com.company;

import java.util.Date;

public class RoomServiceTicket extends Ticket{
    private Date requestedTime; //Time request should be fulfilled
    private String Order;
    private String specialRequest;
    
    public RoomServiceTicket(int roomID, Room room, Date requestTime, Date requestedTime, String Order, String specialRequest) {
    	super("Room Service", roomID, requestTime, false);
    	this.roomID = roomID;
    	this.requestedTime = requestedTime;
    	this.Order = Order;
    	this.specialRequest = specialRequest;
    }

}
