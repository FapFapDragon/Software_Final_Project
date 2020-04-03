package com.company;

import java.util.List;

import com.company.Enums.PermissionType;

public class Manager extends Employee{
    private List<ComplaintTicket> complaints;
    //Display stats about the hotel
    public Manager(PermissionType permissionLevel, String name, String role, float wage) {
    	super(permissionLevel, name, role, wage);
    }
    
    public void hotelStats()
    {
    	//TODO
    }

    public void buildTickets()
    {
    	//TODO
    }

    public void getDiscounts()
    {
    	//TODO
    }

    public void addShift()
    {
    	//TODO
    }

    public void removeShifts()
    {
    	//TODO
    }
    
    //retrieve list of complaints
    public void getComplaints() {
    	//TODO
    }

    public void placeOrder()
    {
    	//TODO
    }

    public void changeWage()
    {
    	//TODO
    }
    
	public void generateOrderRequest() {
		// TODO
	}
	
}
