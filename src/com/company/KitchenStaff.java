package com.company;

import java.util.List;

import com.company.Enums.PermissionType;

public class KitchenStaff extends Employee{

	public KitchenStaff(PermissionType permissionLevel, String name, String role, float wage) {
    	super(permissionLevel, name, role, wage);
    }
	
    //generate request for supplies
    public void generateOrderRequest()
    {

    }
}
