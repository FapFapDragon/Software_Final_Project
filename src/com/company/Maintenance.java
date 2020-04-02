package com.company;

import java.util.ArrayList;

import com.company.Enums.PermissionType;

public class Maintenance extends Employee{
    static private ArrayList<MaintenanceTicket> tickets;
    
    public Maintenance(PermissionType permissionLevel, String name, String role, float wage) {
    	super(permissionLevel, name, role, wage);
    }
   
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
