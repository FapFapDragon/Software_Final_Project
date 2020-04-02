package com.company;

import java.util.ArrayList;

import com.company.Enums.PermissionType;

public class Housekeeping extends Employee {

	public Housekeeping(PermissionType permissionLevel, String name, String role, float wage) {
    	super(permissionLevel, name, role, wage);
    }
	
    //Shared among all kitchen staff
    static private ArrayList<CleaningTicket> activeTickets;

	// generate request for supplies
	public void generateOrderRequest() {
		// TODO
	}
	
}
