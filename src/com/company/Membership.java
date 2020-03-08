package com.company;

import java.util.Date;
import java.util.List;

public class Membership {
    private String type;
    private List<String> perks;
    private int level;
    private Date expiration;

    //Constructor
    public Membership(String type, List<String> perks, int level, Date expiration) {
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
    
	public List<String> getPerks() {
		return perks;
	}

	public void setPerks(List<String> perks) {
		this.perks = perks;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
