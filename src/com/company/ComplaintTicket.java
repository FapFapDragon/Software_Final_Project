package com.company;

import java.util.Date;

public class ComplaintTicket extends Ticket{

    //Constructor
    public ComplaintTicket(String desciption, int roomID, Date openTime, boolean complete)
    {
    	super(desciption, roomID, openTime, complete);
    }
    
}
