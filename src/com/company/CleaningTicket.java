package com.company;

import java.util.Date;

public class CleaningTicket extends Ticket {
    
    public CleaningTicket(String desciption, int roomID, Date openTime, boolean completed) 
    {
    	super(desciption, roomID, openTime, completed);
    }
}
