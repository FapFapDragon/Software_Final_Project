package com.company;

import java.util.ArrayList;

public class Maintenance extends Employee{
    static private ArrayList<MaintenanceTicket> tickets;
    
    
   
    //Move ticket from active to complete
    @Override
    public void CompleteTicket(Ticket ticket)
    {
    		ticket.closeTicket();
    }

    //generate request for supplies
    public void generateOrderRequest()
    {
    	
    }

	
}
