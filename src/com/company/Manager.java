package com.company;

import java.util.List;

import com.company.Enums.PermissionType;

public class Manager extends Employee{
    private List<ComplaintTicket> complaints;
    //Display stats about the hotel
    public Manager(PermissionType permissionLevel, String name, String role, float wage) {
    	super(permissionLevel, name, role, wage);
    }
    
    public void HotelStats()
    {
    	
    }

    public void BuildTickets()
    {
    	
    }

    public void GetDiscounts()
    {

    }

    public void AddShift()
    {

    }

    public void RemoveShifts()
    {

    }
    
    //retrieve list of complaints
    public void getComplaints() {
    	
    }

    public void PlaceOrder()
    {

    }

    public void ChangeWage()
    {

    }
    
	public void generateOrderRequest() {
		// TODO
	}
	
}
