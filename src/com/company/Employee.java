package com.company;

import java.util.List;

public class Employee {
    private int permissionLevel;
    private String name;
    private String ID;
    private String role;
    private List<Shift> shifts; //maybe only store shifts in sql, no need to store in program
    private float wage;
    static private List<OrderRequest> orders; //Shared among all employees


}
