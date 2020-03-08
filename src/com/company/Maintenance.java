package com.company;

import java.util.ArrayList;

public class Maintenance {
    static private ArrayList<MaintenanceTicket> tickets;

    //Move ticket from active to complete
    public void CompleteTicket(MaintenanceTicket ticket)
    {
    		ticket.setComplete(true);
    }

    //generate request for supplies
    public void generateOrderRequest()
    {
    	
    }
}
