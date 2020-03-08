package com.company;

import java.util.Date;
import java.util.ArrayList;

public class Membership {
    private String type;
    private ArrayList<String> perks;
    private int level;
    private Date expiration;

    //Constructor
    public Membership(String type, ArrayList<String> perks, int level, Date expiration) {
        this.type = type;
        this.setPerks(perks);
        this.setLevel(level);
        this.expiration = expiration;
    }
    
    //Function to upgrade membership
    public void upgradeMembership() {
    	setLevel(getLevel() + 1);
    }

    //Function to cancel membership
    public void cancelMembership() {
    	type = null;
    }
    
	public ArrayList<String> getPerks() {
		return perks;
	}

	public void setPerks(ArrayList<String> perks) {
		this.perks = perks;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
