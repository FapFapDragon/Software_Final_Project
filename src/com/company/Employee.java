package com.company;

import java.util.List;

abstract class Employee {
    private int PermissionType; //0 for front desk, 1 for housekeeping, 2 for kitchen staff, 3 for maintenance staff
    private String name;
    private String ID;
    private String role; 
    private List<Shift> shifts; //maybe only store shifts in sql, no need to store in program
    private float wage;
    static private List<OrderRequest> orders; //Shared among all employees
    
    //For manager to view and change shifts
	public List<Shift> getShifts() {
		return shifts;
	}
	public void setShifts(List<Shift> shifts) {
		this.shifts = shifts;
	}
	
	//For manager to set wage
	public float getWage() {
		return wage;
	}
	
	public void setWage(float wage) {
		this.wage = wage;
	}
	
	public abstract void generateOrderRequest();
	
	public void CompleteTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		ticket.closeTicket();
		
	}
    
}
