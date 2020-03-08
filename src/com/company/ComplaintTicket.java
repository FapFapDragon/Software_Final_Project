package com.company;

import java.util.Date;

public class ComplaintTicket {
    private int roomID;
    private Date openTime;
    private boolean complete;
    private String desciption;

    //Constructor
    public ComplaintTicket(String desciption, int roomID, Date openTime, boolean complete)
    {
        this.complete = complete;
        this.desciption = desciption;
        this.roomID = roomID;
        this.openTime = openTime;
    }
    
    public void closeTicket() 
    {
    	complete = true;
    }
    
    
}
