package com.company;

import java.util.Date;

public class Shift {
    private String userID;
    private Date date;
    private float time;
    private boolean changed;
    
    public Shift(String userID, Date date, float time) {
    	this.userID = userID;
    	this.date = date;
    	this.time = time;
    	this.changed = false;
    }
}
