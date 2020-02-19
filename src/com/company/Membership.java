package com.company;

import java.util.Date;
import java.util.List;

public class Membership {
    private String type;
    private List<String> perks;
    private int level;
    private Date expiration;

    //Constructor
    public Membership(String type, List<String> perks, int level, Date expiration)
    {
        this.type = type;
        this.perks = perks;
        this.level = level;
        this.expiration = expiration;
    }

    //Function to upgrade membership
    public void upgradeMembership()
    {

    }

    //Function to cancel membership
    public void cancelMembership()
    {

    }

}
