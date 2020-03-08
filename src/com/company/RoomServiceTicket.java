package com.company;

import java.util.Date;

public class RoomServiceTicket {
    private int roomID;
    private Room room;
    private Date requestTime;   //Time request was made
    private Date requestedTime; //Time request should be fulfilled
    private String Order;
    private String specialRequest;
    
    public RoomServiceTicket(int roomID, Room room, Date requestTime, Date requestedTime, String Order, String specialRequest) {
    	this.roomID = roomID;
    	this.room = room;
    	this.requestTime = requestTime;
    	this.requestedTime = requestedTime;
    	this.Order = Order;
    	this.specialRequest = specialRequest;
    }

}
