package com.company;

import java.util.Date;

public class MaintenanceTicket extends Ticket {
	
    public MaintenanceTicket(String desciption, int roomID, Date openTime, boolean completed) 
    {
    	super(desciption, roomID, openTime, completed);
    }
}
